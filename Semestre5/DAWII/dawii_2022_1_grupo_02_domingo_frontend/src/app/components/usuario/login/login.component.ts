import { FirestoreService } from './../../../services/firestore.service';
import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  credenciales = {
    email: null,
    clave: null,
  };

  errorMensaje: String = ""

  
  constructor(private authService: AuthService,
    private router: Router,
    private firestoreService:FirestoreService ) {}
    
    ngOnInit(): void {
      
    }
    
    async login() {
    const res = await this.authService.login(this.credenciales)
                          .catch(error => {
                            console.log(error);
                            console.log(error.message);
                            console.log(error.code);
                            if (error.code == 'auth/too-many-requests') {
                              this.errorMensaje = "Cuenta temporalmente desactivada por muchos intentos"
                            }else{
                              this.errorMensaje = "Correo o contrasñea equivocada"
                            }
                          });

    if(res){
      console.log("inicio de sesion exitosa");
      this.router.navigate(['/principal'])
    }
  }
}
