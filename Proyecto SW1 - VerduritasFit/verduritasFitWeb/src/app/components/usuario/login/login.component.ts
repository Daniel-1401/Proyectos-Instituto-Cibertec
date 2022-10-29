import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/Models/Users';
import { AuthService } from 'src/app/Services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  usuario: User={
    userName: "",
    clave:"" 
  };
  
  constructor(public authService: AuthService,
              private router: Router) { }

  ngOnInit() {
    if(this.authService.isAutenticado){
      this.router.navigate(['/']);
    }
  }

  login(){
    console.log("usuario",this.usuario);
    this.authService.login(this.usuario).subscribe((data: any) =>{
      sessionStorage.setItem('userName', data.result.userName);
      sessionStorage.setItem('token_value', data.result.token);
      // this.appcomponent.getPermisos();
      this.router.navigate(['/']);
    },
    (errorData) => alert(errorData.error.displayMessage));
  }

}
