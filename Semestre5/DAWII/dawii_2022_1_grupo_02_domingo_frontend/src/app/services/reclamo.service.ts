import Swal from 'sweetalert2';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Reclamo } from '../models/reclamo.model';
import { AppSettings } from '../app.settings';

const baseUrlUtil = AppSettings.API_ENDPOINT+ '/util';
const baseUrlReclamo = AppSettings.API_ENDPOINT+ '/reclamo';


@Injectable({
  providedIn: 'root'
})
export class ReclamoService {

  constructor(private http:HttpClient) {   }

  listarReclamo():Observable<Reclamo[]>{
    return this.http.get<Reclamo[]>(baseUrlReclamo);
  }

  registrarReclamo(reclamo: Reclamo):Observable<any>{
    return this.http.post<any>(baseUrlReclamo,reclamo);
  }

  actualizarReclamo(reclamo: Reclamo):Observable<any>{
    return this.http.put<any>(baseUrlReclamo+"/actualizarReclamo/",reclamo);
  }

  eliminarReclamo(id: number):Observable<any>{
    return this.http.delete<any>(baseUrlReclamo+"/eliminarReclamo/"+id);
  }

  listarConFiltro(filtroUrl: string):Observable<any>{
    return this.http.get(baseUrlReclamo+`${filtroUrl}`)
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
    )
  }

}
