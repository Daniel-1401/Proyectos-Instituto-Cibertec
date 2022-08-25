import { Component, OnInit } from '@angular/core';
import { ModalService } from 'src/app/services/modal.service';
import Swal from 'sweetalert2';
import { Reclamo } from 'src/app/models/reclamo.model';
import { Cliente } from 'src/app/models/cliente.model';
import { TipoReclamo } from 'src/app/models/tipo-reclamo.model';
import { ReclamoService } from 'src/app/services/reclamo.service';
import { ClienteService } from 'src/app/services/cliente.service';
import { TipoReclamoService } from 'src/app/services/tipo-reclamo.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-modal-crud-reclamo',
  templateUrl: './modal-crud.component.html',
  styleUrls: ['./modal-crud.component.css']
})
export class ModalCrudComponentReclamo implements OnInit {

  reclamo: Reclamo = new Reclamo();
  tiposReclamo: TipoReclamo[] = []
  titulo: String = "Actualizar Reclamo"
  

  constructor(
    public modalService: ModalService,
    private reclamoService: ReclamoService,
    private tipoReclamo: TipoReclamoService,
    private route: Router) { }

  ngOnInit(): void {
    this.escucharAperturaModal()

    this.cargarTiposReclamo()
  }
  cargarTiposReclamo() {
    this.tipoReclamo.listaTipoReclamo().subscribe((data)=>{
      this.tiposReclamo = data
      console.log(this.tiposReclamo)
    })
  }
  escucharAperturaModal() {

    this.modalService.notificarAbrirModalCrudReclamo.subscribe((obj) => {
      this.reclamo = obj
      console.log(this.reclamo)
      if (obj.idReclamo == null) {
          this.route.navigate(["registraReclamo"]);
      } else {
        this.titulo = "Actualizar Cliente"
      }
    })
  }

  cerrarModal() {
    this.reclamo = new Reclamo();
    this.modalService.cerrarModalCrudReclamo()
  }

  actualizar() {
    console.log("Entro a Actualizar")
    this.reclamoService.actualizarReclamo(this.reclamo)
      .subscribe(response => {
        console.log(response)
        this.modalService.cerrarModalCrudReclamo()
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: `${response.message}.`,
          showConfirmButton: false,
          timer: 3500
        })
      },
        err => {
          console.log(err)
          Swal.fire({
            position: 'center',
            icon: 'error',
            title: `Error al actualizar el reclamo - ${err.message}`,
            showConfirmButton: false
          })
          console.error(err)

        }
      )
  }
  

}
