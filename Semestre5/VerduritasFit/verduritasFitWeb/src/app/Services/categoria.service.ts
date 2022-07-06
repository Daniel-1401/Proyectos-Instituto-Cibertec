import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Categoria } from '../Models/Categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  /* Setting the baseUrl for the service. */
  baseUrl: string  = environment.API_URL+'Categoria/'

  constructor(private http:HttpClient) { }

  listarCategoria():Observable<Categoria[]>{
    let auth_token = sessionStorage.getItem('token_value');
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${auth_token}`
    }) 
    return this.http.get<Categoria[]>(this.baseUrl+"listarCategorias", {headers: headers})
  }
  buscarCategoria(id: number):Observable<Categoria>{
    let auth_token = sessionStorage.getItem('token_value');
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${auth_token}`
    }) 
    return this.http.get<Categoria>(this.baseUrl+"buscarCategoriaPorId/"+id, {headers:  headers});
  }
  crearCategoria(categoria: Categoria){  
    let auth_token = sessionStorage.getItem('token_value');
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${auth_token}`
    }) 
    return this.http.post(this.baseUrl+"insertarCategoria/", categoria, {headers:  headers});
  }

  actualizarCategoria(categoria: Categoria){ 
    let auth_token = sessionStorage.getItem('token_value');
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${auth_token}`
    }) 
    return this.http.put(this.baseUrl+"actualizarCategoria/", categoria, {headers:  headers});
  }

  eliminarCategoria(id: number){ 
    let auth_token = sessionStorage.getItem('token_value');
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${auth_token}`
    }) 
    return this.http.delete(this.baseUrl+"eliminarCategoria/"+id, {headers:  headers});
  }
}
