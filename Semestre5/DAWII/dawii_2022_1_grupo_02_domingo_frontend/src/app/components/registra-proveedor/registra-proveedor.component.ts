import { Component, OnInit } from '@angular/core';
import { switchAll } from 'rxjs';
import { Proveedor } from 'src/app/models/proveedor.model';
import { Ubigeo } from 'src/app/models/ubigeo.model';
import { ProveedorService } from 'src/app/services/proveedor.service';
import { UbigeoService } from 'src/app/services/ubigeo.service';

import Swal from "sweetalert2";

@Component({
  selector: 'app-registra-proveedor',
  templateUrl: './registra-proveedor.component.html',
  styleUrls: ['./registra-proveedor.component.css']
})
export class RegistraProveedorComponent implements OnInit {

  titulo:String= "Registrar Proveedor"

  departamentos: string[] = [];
  provincias: string[] = [];
  distritos: Ubigeo[] = [];

  proveedor: Proveedor


  constructor(private ubigeoService: UbigeoService, private proveedorService:ProveedorService) {
    this.proveedor=new Proveedor()
    this.proveedor.ubigeo={
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
    console.log(">>> Departamento >> " + this.proveedor.ubigeo?.departamento);

    this.ubigeoService.listaProvincias(this.proveedor.ubigeo?.departamento).subscribe(
      (x) => {
        this.provincias = x

        console.log(this.provincias)
      }
    );

    this.proveedor.ubigeo!.provincia = "-1";
    this.distritos = [];
    this.proveedor.ubigeo!.idUbigeo = -1;

  }

  cargaDistrito() {
    console.log(">>> Carga Distrito >> ");
    console.log(">>> Departamento >> " + this.proveedor.ubigeo?.departamento);
    console.log(">>> Provincia >> " + this.proveedor.ubigeo?.provincia);

    this.ubigeoService.listaDistritos(this.proveedor.ubigeo?.departamento, this.proveedor.ubigeo?.provincia).subscribe(
      (x) => {
        this.distritos = x
        console.log(this.distritos)
      }
    );

    this.proveedor.ubigeo!.idUbigeo = -1;
  }

  registrar(){
    console.log("Entro a registrar")
    this.proveedorService.registrarProveedor(this.proveedor)
    .subscribe(response => {
      console.log(response)
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: `Se registro exitosamente el proveedor - ${response.message}.`,
        showConfirmButton: false,
        timer: 3500
      })
    },
      err => {
        console.log(err)
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: `Error al registrar al proveedor - ${err.message}`,
          showConfirmButton: false
        })
        console.error(err)

      }
    )
  }

}
