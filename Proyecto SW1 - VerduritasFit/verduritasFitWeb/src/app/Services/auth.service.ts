import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { User } from '../Models/Users';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  baseUrl: string = environment.API_URL + 'User/'

  constructor(private http: HttpClient,
              private router: Router) { }

  login(user: User){
    console.log("entre en login service", user)
    return this.http.post(this.baseUrl+'Login', user)
  }
  logout(){
    sessionStorage.clear();
    this.router.navigate(['/']);
    window.location.reload();
  }
  get isAutenticado(){
    return !!sessionStorage.getItem('token_value');
  }
}
