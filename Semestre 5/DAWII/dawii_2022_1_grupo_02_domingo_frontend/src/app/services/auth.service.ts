import { Injectable } from '@angular/core';
import { Auth, createUserWithEmailAndPassword, signOut, authState, User } from "@angular/fire/auth";
import { signInWithEmailAndPassword } from '@firebase/auth';
import { Observable } from 'rxjs';
import { UserInterface } from '../models/userInterface';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public userData$: Observable<User | null>;
  constructor(private auth: Auth) {
    this.userData$ = this.stateUser();
   }

  register(datos: UserInterface){
    return createUserWithEmailAndPassword(this.auth, datos.email, datos.clave);
  }

  login({email, clave}: any){
    
    return signInWithEmailAndPassword(this.auth, email, clave);
  }

  logout(){
    return signOut(this.auth)
  }

  stateUser(){
    return authState(this.auth);
  }
}
