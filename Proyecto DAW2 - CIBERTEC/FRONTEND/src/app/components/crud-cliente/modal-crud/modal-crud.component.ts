import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/models/cliente.model';
import { Ubigeo } from 'src/app/models/ubigeo.model';
import { ClienteService } from 'src/app/services/cliente.service';
import { ModalService } from 'src/app/services/modal.service';
import { UbigeoService } from 'src/app/services/ubigeo.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-modal-crud',
  templateUrl: './modal-crud.component.html',
  styleUrls: ['./modal-crud.component.css']
})
export class ModalCrudComponent implements OnInit {
  cliente: Cliente = new Cliente();
  titulo: String = "Registrar Cliente"
  departamentos: string[] = [];
  provincias: string[] = [];
  distritos: Ubigeo[] = [];


  constructor(
    public modalService: ModalService,
    private ubigeoService: UbigeoService,
    private clienteService: ClienteService
  ) { }

  ngOnInit(): void {
    this.escucharAperturaModal()

    this.cargarDepartamento()


  }
  cargarDepartamento() {
    this.ubigeoService.listarDepartamento().subscribe(

      (x) => {
        this.departamentos = x
        console.log(x)
      }
    );
  }

  cargaProvincia() {
    console.log(">>> Carga Provincia >> ");
    console.log(">>> Departamento >> " + this.cliente.ubigeo?.departamento);

    this.ubigeoService.listaProvincias(this.cliente.ubigeo?.departamento).subscribe(
      (x) => this.provincias = x
    );

    this.cliente.ubigeo!.provincia = "-1";
    this.distritos = [];
    this.cliente.ubigeo!.idUbigeo = -1;

  }

  cargaDistrito() {
    console.log(">>> Carga Distrito >> ");
    console.log(">>> Departamento >> " + this.cliente.ubigeo?.departamento);
    console.log(">>> Provincia >> " + this.cliente.ubigeo?.provincia);

    this.ubigeoService.listaDistritos(this.cliente.ubigeo?.departamento, this.cliente.ubigeo?.provincia).subscribe(
      (x) => this.distritos = x
    );

    this.cliente.ubigeo!.idUbigeo = -1;
  }

  escucharAperturaModal() {

    this.modalService.notificarAbrirModalCrudCliente.subscribe((obj) => {
      console.log("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
      this.cliente = obj
      if (obj.idCliente == null) {
        this.titulo = "Registrar Cliente"
        this.cliente.ubigeo = {
          idUbigeo: -1,
          departamento: "",
          provincia: "",
          distrito: "",
        }
      } else {
        this.titulo = "Actualizar Cliente"
        
        this.ubigeoService.listaProvincias(obj.ubigeo?.departamento).subscribe(
          response => {
            this.provincias = response
          }
        );

        this.ubigeoService.listaDistritos(obj.ubigeo?.departamento, obj.ubigeo?.provincia).subscribe(
          response => {
            this.distritos = response
            this.distritos.forEach(dis=>{
             console.log(dis.idUbigeo==this.cliente.ubigeo!.idUbigeo)
            })
            console.log(this.distritos)
            console.log(this.cliente)
          }
        );
      }
    })
  }
  cerrarModal() {
    this.cliente = new Cliente();
    this.cliente.ubigeo = {
      idUbigeo: -1,
      departamento: "",
      provincia: "",
      distrito: "",
    }
    this.provincias = [];
    this.distritos= [];
    this.modalService.cerrarModalCrudCliente()
  }

  registrar() {
    console.log("Entro a registrar")
    this.clienteService.registrarCliente(this.cliente)
      .subscribe(response => {
        this.modalService.cerrarModalCrudCliente()
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
            title: `Error al registrar al cliente - ${err.message}`,
            showConfirmButton: false
          })
          console.error(err)

        }
      )
  }

  actualizar() {
    console.log("Entro a Actualizar")
    this.clienteService.actualizarCliente(this.cliente)
      .subscribe(response => {
        console.log(response)
        this.modalService.cerrarModalCrudCliente()
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
            title: `Error al actualizar el cliente - ${err.message}`,
            showConfirmButton: false
          })
          console.error(err)

        }
      )
  }
}
