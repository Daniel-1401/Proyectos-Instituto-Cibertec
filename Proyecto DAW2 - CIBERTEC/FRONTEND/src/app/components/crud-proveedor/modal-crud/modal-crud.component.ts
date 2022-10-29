import { Component, OnInit } from "@angular/core";
import { Proveedor } from "src/app/models/proveedor.model";
import { Ubigeo } from "src/app/models/ubigeo.model";
import { ModalService } from "src/app/services/modal.service";
import { ProveedorService } from "src/app/services/proveedor.service";
import { UbigeoService } from "src/app/services/ubigeo.service";
import Swal from "sweetalert2";
import { CrudProveedorComponent } from "../crud-proveedor.component";

@Component({
    selector: 'app-modal-crud-proveedor',
    templateUrl: './modal-crud.component.html',
    styleUrls: ['./modal-crud.component.css']
  })
  export class ModalCrudComponentPro implements OnInit {
    
    proveedor: Proveedor = new Proveedor();
    titulo:String= "Registrar Proveedor"

    departamentos: string[] = [];
    provincias: string[] = [];
    distritos: Ubigeo[] = [];
  
    constructor(
        public proveedorService: ProveedorService,
        public modalService: ModalService,
        public ubigeoService: UbigeoService,
        public crudProveedorComponent: CrudProveedorComponent
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

    escucharAperturaModal() {
        this.modalService.notificarAbrirModalCrudProveedor.subscribe((obj) => {
          console.log("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
          this.proveedor = obj
          if (obj.idProveedor == null) {
            this.titulo = "Registrar Proveedor"
            this.proveedor.ubigeo = {
              idUbigeo: -1,
              departamento: "",
              provincia: "",
              distrito: "",
            }
          } else {
            this.titulo = "Actualizar Proveedor"
            
            this.ubigeoService.listaProvincias(obj.ubigeo?.departamento).subscribe(
              response => {
                this.provincias = response
              }
            );
    
            this.ubigeoService.listaDistritos(obj.ubigeo?.departamento, obj.ubigeo?.provincia).subscribe(
              response => {
                this.distritos = response
                this.distritos.forEach(dis=>{
                 console.log(dis.idUbigeo==this.proveedor.ubigeo!.idUbigeo)
                })
                console.log(this.distritos)
                console.log(this.proveedor)
              }
            );
          }
        })
      }

      cerrarModal() {
        this.proveedor = new Proveedor();
        this.proveedor.ubigeo = {
          idUbigeo: -1,
          departamento: "",
          provincia: "",
          distrito: "",
        }
        this.provincias = [];
        this.distritos= [];
        this.modalService.cerrarModalCrudProveedor()
        this.crudProveedorComponent.listarProveedor();
      }
  
    registrar(){
      console.log("Entro a registrar")
      this.proveedorService.registrarProveedor(this.proveedor)
      .subscribe(response => {
        this.modalService.cerrarModalCrudProveedor()
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

    actualizar() {
        console.log("Entro a Actualizar")
        this.proveedorService.actualizarProveedor(this.proveedor)
          .subscribe(response => {
            console.log(response)
            this.modalService.cerrarModalCrudProveedor()
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
                title: `Error al actualizar el proveedor - ${err.message}`,
                showConfirmButton: false
              })
              console.error(err)
    
            }
          )
      }
  

  }