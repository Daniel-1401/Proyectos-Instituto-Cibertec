import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Cliente } from 'src/app/models/cliente.model';
import { ClienteService } from 'src/app/services/cliente.service';
import { ModalService } from 'src/app/services/modal.service';
import { UbigeoService } from 'src/app/services/ubigeo.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-crud-cliente',
  templateUrl: './crud-cliente.component.html',
  styleUrls: ['./crud-cliente.component.css']
})
export class CrudClienteComponent implements OnInit {

  clientes: Cliente[] = [];


  public estados = [{ id: 1, descripcion: 'Activo' },
  { id: 0, descripcion: 'Inactivo' }]

  public filtroNombre: string = '';
  public filtroDni: string = '';
  public filtroCorreo: string = '';



  selectedEstado: number = 1
  validEstado = new FormControl('valid', [Validators.required, Validators.pattern('[0-2]')]);

  constructor(
    public modalService:ModalService,
     private clienteService: ClienteService
  ) { }

  ngOnInit(): void {
    this.escucharCierreModalVisitante()
    this.listarCliente()
  }

  escucharCierreModalVisitante() {   
    this.modalService.notificarCerrarModalCrudCliente.subscribe(() => {
      this.listarCliente()
    })
  }

  registrar() {
    let cli= new Cliente()
    this.modalService.abrirModalCrudCliente(cli)
  }
  actualizar(cli:Cliente) {
    this.modalService.abrirModalCrudCliente(cli)
  }

  listarCliente() {//
    let filtroURL = `/filtro?nombre=${this.filtroNombre}&correo=${this.filtroCorreo}&dni=${this.filtroDni}&estado=${this.selectedEstado}`

    this.clienteService.listarConFiltro(filtroURL)
      .subscribe(response => {
        console.log(response)
        this.clientes = response.lista as Cliente[];
      });
  }
  eliminar(cli: Cliente) {
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
            this.clienteService.eliminarCliente(cli).subscribe(
              (x) => {
                this.listarCliente()
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
  
    cambiarActive(cli:Cliente){
      cli.estado= cli.estado==1?0:1
      this.clienteService.actualizarCliente(cli).subscribe(response => { this.listarCliente()})
     
    }
  
  
    buscarEstado() {
    this.listarCliente()
  }
  
  buscarNombre() {
    this.filtroDni = ''
    this.filtroCorreo = ''
    this.listarCliente()
  }
  buscarDNI() {
    this.filtroNombre = ''
    this.filtroCorreo = ''
    this.listarCliente()
  }
  buscarCorreo() {
    this.filtroNombre = ''
    this.filtroDni = ''
    this.listarCliente()
  }
}
