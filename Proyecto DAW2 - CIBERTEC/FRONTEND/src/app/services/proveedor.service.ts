import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Proveedor } from '../models/proveedor.model';
import { AppSettings } from '../app.settings';
import Swal from 'sweetalert2';

const baseUrlUtil = AppSettings.API_ENDPOINT+ '/util';
const baseUrlProveedor = AppSettings.API_ENDPOINT+ '/proveedor';


@Injectable({
  providedIn: 'root'
})
export class ProveedorService {

  constructor(private http: HttpClient) { }
  

  listaProveedor():Observable<Proveedor[]>{
    return this.http.get<Proveedor[]>(baseUrlUtil+"/listaProveedor");
  }

  registrarProveedor(proveedor:Proveedor):Observable<any>{
    return this.http.post<any>(baseUrlProveedor+"/Registrar", proveedor);
  }

  actualizarProveedor(proveedor:Proveedor):Observable<any>{
    return this.http.put<any>(baseUrlProveedor+"/actualizar/"+proveedor.idProveedor, proveedor);
  }
  eliminarProveedor(proveedor:Proveedor):Observable<any>{
    return this.http.delete<any>(baseUrlProveedor+"/eliminar/"+proveedor.idProveedor);
  }

  listarConFiltro(FiltrarURL:string): Observable<any> {
       
     
    return this.http.get(baseUrlProveedor+`${FiltrarURL}`)
      .pipe(
        catchError(e => {
          Swal.fire({
   
            position: 'center',
            
            title: `Error en el listado con filtro `,
            icon: 'error',
            text: `Busque con caracteres correctos `,
            showConfirmButton: false,
            timer: 2500
          })
          console.log(e)
          return throwError(e);
        })
      );
  }
  
}
