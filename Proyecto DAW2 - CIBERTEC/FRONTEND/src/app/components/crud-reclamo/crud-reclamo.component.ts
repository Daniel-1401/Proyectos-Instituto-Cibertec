import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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
  selector: 'app-crud-reclamo',
  templateUrl: './crud-reclamo.component.html',
  styleUrls: ['./crud-reclamo.component.css']
})
export class CrudReclamoComponent implements OnInit {

  range = new FormGroup({
    start: new FormControl(),
    end: new FormControl(),
  });
  reclamos: Reclamo[] = []
  clientes: Cliente[] = [];
  tiposReclamo: TipoReclamo[] = []

  public estados = [
                    {id: 1, descripcion: 'Activo'},
                    {id: 0, descripcion: 'Inactivo'}
                  ]

  public filtroDescripcion: string = '';
  public filtroRangoInicialFecha: String = '';
  public filtroRangoFinalFecha: String = '';
  selCliente: String = "-1";
  selTipoReclamo: String = "-1";
  selectedEstado: number = 1
  validEstado = new FormControl('valid', [Validators.required, Validators.pattern('[0-2]')]);

  constructor(private reclamoService: ReclamoService,
              public modalService:ModalService,
              private clienteService: ClienteService,
              private tipoReclamo: TipoReclamoService,
              private route: Router) { }

  ngOnInit(): void {
    this.escucharCierreModalVisitante()
    this.listarReclamos()
    this.obtenerClientes()
    this.obtenerTiposReclamos()
  }

  escucharCierreModalVisitante() {   
    this.modalService.notificarCerrarModalCrudReclamo.subscribe(() => {
      this.listarReclamos()
    })
  }

  listarReclamos() {
    let filtroURL = `/filtro?` +
                    `descripcion=${this.filtroDescripcion}` +
                    `&rangoInicioFecha=${this.filtroRangoInicialFecha}` +
                    `&rangoFinFecha=${this.filtroRangoFinalFecha}` +
                    `&estado=${this.selectedEstado}` +
                    `&idCliente=${this.selCliente}` +
                    `&idTipoReclamo=${this.selTipoReclamo}`
    this.reclamoService.listarConFiltro(filtroURL).subscribe((data) =>{
      this.reclamos = data.lista
    })
  }

  registrar() {
    let reclamo= new Reclamo()
    this.route.navigate(["registraReclamo"]);
  }
  actualizar(reclamo: Reclamo) {
    this.modalService.abrirModalCrudReclamo(reclamo)
  }

  eliminar(id: number) {
    Swal.fire({
      title: 'Está seguro que desea eliminar?',
      text: "No se va a poder revertir!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, Eliminar!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.reclamoService.eliminarReclamo(id).subscribe(
          (x) => {
            this.listarReclamos()
            Swal.fire(
              'Eliminado!',
              'Elimando Correctamente.',
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
  obtenerClientes() {
    this.clienteService.listaCliente().subscribe((data) => {
      //console.log("Data clientes ->",data)
      this.clientes = data
      // console.log("Clientes -> ",this.clientes)
    })
  }
  obtenerTiposReclamos() {
    this.tipoReclamo.listaTipoReclamo().subscribe((data)=>{
      //console.log("Data Tipos Reclamo -> ", data)
      this.tiposReclamo = data
      // console.log("Tipos reclamos -> ", this.tiposReclamo)
    })
  }

  cambiarActive(reclamo: Reclamo){
    reclamo.estado = reclamo.estado == 1 ? 0 : 1
    this.reclamoService.actualizarReclamo(reclamo).subscribe(response => { this.listarReclamos()})
  }
  buscarEstado() {
    this.listarReclamos()
  }

  buscarDescripcionClienteTipoReclamo(){
    this.listarReclamos();
  }

  buscarRangoFechas(){
    this.filtroRangoFinalFecha = ''
    this.filtroRangoInicialFecha = ''
    this.range.reset()
    // console.log("Entre en rango fechas")
  }
  obtenerFechaInicial(){
    let fecha: Date;
    // console.log("ENTRE EN OBTENER FECHA INICIAL")
    fecha = this.range.value.start
    this.filtroRangoInicialFecha = `${fecha.getFullYear()}-${fecha.getMonth() + 1}-${fecha.getDate()}`
    // console.log("FECHA INICIAL FORMATEADA ->", this.filtroRangoInicialFecha)
  }
  obtenerFechaFinal(){
    let fecha: Date;
    // console.log("ENTRE EN OBTENER FECHA FINAL")
    fecha = this.range.value.end
    this.filtroRangoFinalFecha = `${fecha.getFullYear()}-${fecha.getMonth() + 1}-${fecha.getDate()}`
    // console.log("FECHA FINAL FORMATEADA ->", this.filtroRangoFinalFecha)
    this.listarReclamos()
  }

}
