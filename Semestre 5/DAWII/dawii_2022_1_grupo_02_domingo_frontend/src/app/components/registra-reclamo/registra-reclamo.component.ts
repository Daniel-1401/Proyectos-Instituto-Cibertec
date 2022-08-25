import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/models/cliente.model';
import { Reclamo } from 'src/app/models/reclamo.model';
import { TipoReclamo } from 'src/app/models/tipo-reclamo.model';
import { ClienteService } from 'src/app/services/cliente.service';
import { ReclamoService } from 'src/app/services/reclamo.service';
import { TipoReclamoService } from 'src/app/services/tipo-reclamo.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-registra-reclamo',
  templateUrl: './registra-reclamo.component.html',
  styleUrls: ['./registra-reclamo.component.css']
})
export class RegistraReclamoComponent implements OnInit {

  tipoReclamos: TipoReclamo[] = [];
  clientes: Cliente[] = [];

  reclamo: Reclamo = new Reclamo();

  constructor(private reclamoService: ReclamoService,
              private tipoReclamoService: TipoReclamoService,
              private clienteService: ClienteService) 
  {
    this.reclamo = {
      idReclamo: 0,
      cliente: {
        idCliente: -1
      },
      tipoReclamo : {
        idTipoReclamo : -1
      }
    }
  }

  ngOnInit(): void {

    console.log("entre ngOnInit")
    this.tipoReclamoService.listaTipoReclamo()
      .subscribe((data) =>{
        this.tipoReclamos = data
        console.log("Lista de Tipos Reclamo")
        console.log(this.tipoReclamos)
      });

    this.clienteService.listaCliente()
      .subscribe((data) =>{
        this.clientes = data
        console.log("Lista de Clietes")
        console.log(this.clientes)
      });
  }

  registrarReclamo(){
    console.log("Entre a registrar Reclamo")
    console.log(this.reclamo)
    this.reclamoService.registrarReclamo(this.reclamo)
      .subscribe((data) => {
        console.log("data")
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: `${data.message}.`,
          showConfirmButton: false,
          timer: 3500
        })
      },
      err => {
        console.log(err)
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: `Error al registrar el reclamo - ${err.message}`,
          showConfirmButton: false
        })
        console.error(err)

      }
    );
  }

}
