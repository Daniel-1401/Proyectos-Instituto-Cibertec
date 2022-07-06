import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { Cliente } from 'src/app/models/cliente.model';
import { Ubigeo } from 'src/app/models/ubigeo.model';
import { ClienteService } from 'src/app/services/cliente.service';
import { UbigeoService } from 'src/app/services/ubigeo.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-registra-cliente',
  templateUrl: './registra-cliente.component.html',
  styleUrls: ['./registra-cliente.component.css']
})
export class RegistraClienteComponent implements OnInit {
 
  titulo:String= "Registrar Cliente"
  departamentos: string[] = [];
  provincias: string[] = [];
  distritos: Ubigeo[] = [];

  cliente: Cliente


  constructor(private ubigeoService: UbigeoService, private clienteService:ClienteService) {
    this.cliente=new Cliente()
    this.cliente.ubigeo={
      idUbigeo:-1,
      departamento:"-1",
      provincia:"-1",
      distrito:"",
    }

   }

  ngOnInit(): void {

    this.ubigeoService.listarDepartamento().subscribe(
     
      (x) =>{ 
        this.departamentos=x
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
 
  registrar(){
    console.log("Entro a registrar")
    this.clienteService.registrarCliente(this.cliente)
    .subscribe(response => {
      console.log(response)
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
          title: `Error al registrar al visitante - ${err.message}`,
          showConfirmButton: false
        })
        console.error(err)

      }
    )
  }

}
