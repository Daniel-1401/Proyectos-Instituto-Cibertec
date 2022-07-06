import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import Swal from 'sweetalert2';
import { AppSettings } from '../app.settings';
import { Cliente } from '../models/cliente.model';

const baseUrlUtil = AppSettings.API_ENDPOINT+ '/util';
const baseUrlCliente = AppSettings.API_ENDPOINT+ '/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  
  constructor(private http:HttpClient) { }

  listaCliente():Observable<Cliente[]>{
    return this.http.get<Cliente[]>(baseUrlUtil+"/listaCliente");
  }

  registrarCliente(cliente:Cliente):Observable<any>{
    return this.http.post<any>(baseUrlCliente+"/crear", cliente);
  }
  actualizarCliente(cliente:Cliente):Observable<any>{
    return this.http.put<any>(baseUrlCliente+"/actualziar/"+cliente.idCliente, cliente);
  }
  eliminarCliente(cliente:Cliente):Observable<any>{
    return this.http.delete<any>(baseUrlCliente+"/eliminar/"+cliente.idCliente);
  }
  listarConFiltro(filtroURL:string): Observable<any> {
       
     
    return this.http.get(baseUrlCliente+`${filtroURL}`)
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
