import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Proveedor } from 'src/app/models/proveedor.model';
import { Ubigeo } from 'src/app/models/ubigeo.model';
import { ModalService } from 'src/app/services/modal.service';
import { ProveedorService } from 'src/app/services/proveedor.service';
import { UbigeoService } from 'src/app/services/ubigeo.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-crud-proveedor',
  templateUrl: './crud-proveedor.component.html',
  styleUrls: ['./crud-proveedor.component.css']
})
export class CrudProveedorComponent implements OnInit {

  proveedor: Proveedor[] = [];

  public estados = [{ id: 1, descripcion: 'Activo' },
  { id: 0, descripcion: 'Inactivo' }]

  public FiltrarRazonSocial: string = '';
  public FiltrarRuc: string = '';

  selectedEstado: number = 1
  validEstado = new FormControl('valid', [Validators.required, Validators.pattern('[0-2]')]);

  constructor(
    public modalService:ModalService, 
      private proveedorService: ProveedorService) { }

  ngOnInit(): void {
    this.escucharCierreModalProveedor()
    this.listarProveedor()
    }

    escucharCierreModalProveedor() {   
      this.modalService.notificarCerrarModalCrudProveedor.subscribe(() => {
        this.listarProveedor()
      })
    }

    registrar() {
      let pro = new Proveedor()
      this.modalService.abrirModalCrudProveedor(pro)
    }
    actualizar(pro:Proveedor) {
      this.modalService.abrirModalCrudProveedor(pro)
    }

  listarProveedor() {//
    let FiltrarURL = `/Filtrar?razonsocial=${this.FiltrarRazonSocial}&ruc=${this.FiltrarRuc}&estado=${this.selectedEstado}`
    this.proveedorService.listarConFiltro(FiltrarURL)
      .subscribe(response => {
        console.log(response)
        this.proveedor = response.lista as Proveedor[];
      });
  }

  eliminar(pro: Proveedor) {
    Swal.fire({
      title: 'Está seguro que desea eliminar?',
      text: "No se va a poder revertir!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, Eliminar!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.proveedorService.eliminarProveedor(pro).subscribe(
          (x) => {
            this.listarProveedor()
            Swal.fire(
              'Eliminado!',
              'Proveedor Elimando Correctamente.',
              'success'
            )
          },
          err => {
            console.log(err)
            Swal.fire({
              position: 'center',
              icon: 'error',
              title: `${err.error.message}`,
              text: `${err.error.data}`,
              showConfirmButton: false
            })
            console.error(err)
  
          }
        );
      }
    })
}

cambiarActive(pro:Proveedor){
  pro.estado= pro.estado==1?0:1
  this.proveedorService.actualizarProveedor(pro).subscribe(response => { this.listarProveedor()})
 
}
buscarEstado() {
  this.listarProveedor()
}

  buscarRazonSocial() {
    this.FiltrarRuc = ''
    this.listarProveedor()
  }
  buscarRuc() {
    this.FiltrarRazonSocial = ''
    this.listarProveedor()
  }
  
}
