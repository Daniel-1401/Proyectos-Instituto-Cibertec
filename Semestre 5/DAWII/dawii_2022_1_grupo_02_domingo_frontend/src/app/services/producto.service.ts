import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Producto } from '../models/producto.model';
import { AppSettings } from '../app.settings';
import Swal from 'sweetalert2';

const baseUrlUtil = AppSettings.API_ENDPOINT+ '/util';
const baseUrlProducto = AppSettings.API_ENDPOINT+ '/producto';


@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http:HttpClient) { }

  listarProducto():Observable<Producto[]>{
    return this.http.get<Producto[]>(baseUrlUtil + "/listaProducto");
  }

  registrarProducto(producto: Producto):Observable<any>{
    return this.http.post<any>(baseUrlProducto + "/crear",producto);
  }

  listarFiltro(filtroURL: string): Observable<any>{
    return this.http.get<any>(baseUrlProducto + filtroURL).pipe(
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

  actualizarProducto(producto: Producto): Observable<any>{
    return this.http.put<any>(baseUrlProducto + '/actualizar/'+producto.idProducto, producto, {headers: this.httpHeaders});
  }
  eliminarProducto(producto: Producto): Observable<any>{
    return this.http.delete<any>(baseUrlProducto + '/eliminar/'+producto.idProducto, {headers: this.httpHeaders});
  }

}


