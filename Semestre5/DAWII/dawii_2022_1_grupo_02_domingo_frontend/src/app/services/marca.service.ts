import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { AppSettings } from '../app.settings';
import { Marca } from '../models/marca.model';
import Swal from 'sweetalert2';

const baseUrlUtil = AppSettings.API_ENDPOINT+ '/util';
const baseUrlMarca = AppSettings.API_ENDPOINT+ '/marca';

@Injectable({
  providedIn: 'root',
})
export class MarcaService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) {  }

  listaMarca(): Observable<Marca[]> {
    return this.http.get<Marca[]>(baseUrlUtil + '/listaMarca');
  }

  create(marca: Marca): Observable<Marca>{
    return this.http.post<Marca>(baseUrlMarca + '/crear', marca, {headers: this.httpHeaders});
  }

  listarFiltro(filtroURL: string): Observable<any>{
    return this.http.get<any>(baseUrlMarca + filtroURL).pipe(
      catchError( e => {
        Swal.fire({
          title: 'Error al listar',
          position: 'center',
          icon: 'error',
          text: "Escriba caracteres correctos",
          showConfirmButton: false,
          timer: 2000
        })
        return throwError( () => e );
      })
    );
  }

  actualizarMarca(marca: Marca): Observable<any>{
    return this.http.put<any>(baseUrlMarca + '/actualizar/'+marca.idMarca, marca, {headers: this.httpHeaders});
  }
  eliminarMarca(marca: Marca): Observable<any>{
    return this.http.delete<any>(baseUrlMarca + '/eliminar/'+marca.idMarca, {headers: this.httpHeaders});
  }
}
