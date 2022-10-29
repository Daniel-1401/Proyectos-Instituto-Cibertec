import { FirestoreService } from './../../../services/firestore.service';
import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from "@angular/router";
import Swal from 'sweetalert2';
import { UserInterface } from 'src/app/models/userInterface';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  titulo = "REGISTRAR"
  user: UserInterface = {
    email: "",
    clave: "",
    nombre: undefined,
    perfil: undefined,
    uid: undefined
  }

  perfiles = ['cliente','marca','producto','proveedor','reclamo','sede','admin']

  constructor(private auth: AuthService,
              private router: Router,
              private firestoreService: FirestoreService) {}
    
  ngOnInit(): void {
    console.log("hola");
    
    this.firestoreService.getUser().subscribe(usuarios => {
      console.log(usuarios);
    })

    this.firestoreService.getUserById("1y7Piv9qz6hfLE4EatCVkz31aJT2").subscribe( usuario => {
      console.log(usuario);
      
    })
    
  }

  async register(){
    console.log("usuario->",this.user);
    const res = await this.auth.register(this.user)
      .catch(error => {
        console.log(error);
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: `Error al registrar`,
          showConfirmButton: false
        })
      })

      if(res){
        console.log(res);
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: `Se registro correctamente.`,
          showConfirmButton: false,
          timer: 3500
        });
        const id = res.user.uid;
        this.user.uid = id;
        this.user.clave = null!;
        await this.firestoreService.createDoc(this.user, id)
                .then(response => console.log(response))
                .catch(error => console.log(error))
      }
  }

}
