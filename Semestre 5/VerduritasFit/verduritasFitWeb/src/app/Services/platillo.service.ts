import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Platillo } from '../Models/Platillo';

@Injectable({
  providedIn: 'root'
})
export class PlatilloService {

  baseUrl: string  = environment.API_URL+'Platillo/'

  constructor(private http:HttpClient) { }

  listarPlatillos():Observable<Platillo[]>{
    let auth_token = sessionStorage.getItem('token_value');
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${auth_token}`
    }) 
    return this.http.get<Platillo[]>(this.baseUrl+"listarPlatillos", {headers: headers})
  }
}
