import { Component, OnInit } from '@angular/core';
import { Marca } from 'src/app/models/marca.model';
import { Pais } from 'src/app/models/pais.model';
import { MarcaService } from 'src/app/services/marca.service';
import { PaisService } from 'src/app/services/pais.service';
import { ModalService } from 'src/app/services/modal.service';
import { CrudMarcaComponent } from 'src/app/components/crud-marca/crud-marca.component';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-modal-crud-marca',
  templateUrl: './modal-crud.component.html',
  styleUrls: ['./modal-crud.component.css']
})
export class ModalCrudComponentMarca implements OnInit {

  marca: Marca = new Marca();
  titulo: String = "Registrar Marca";
  public pais: Pais[] = [];
  public estados = [{ id: 1, descripcion: 'Activo' },
  { id: 0, descripcion: 'Inactivo' }]


  constructor(
    public marcaService: MarcaService,
    public paisService: PaisService,
    public modalService: ModalService,
    public crudMarcaComponent: CrudMarcaComponent
  ) { }

  ngOnInit(): void {
    this.escucharAperturaModal();
    this.cargarPais();
  }

  cargarPais() {
    this.paisService.listaPais().subscribe(pais => this.pais = pais)
  }

  escucharAperturaModal() {
    this.modalService.notificarAbrirModalCrudMarca.subscribe(obj => {
      this.marca = obj;

      if (obj.idMarca == null) {
        this.titulo = "Registrar Marca";
        this.marca.pais = {
          idPais: -1
        }
      } else {
        this.titulo = "Editar Marca";

        this.paisService.listaPais().subscribe(pais => this.pais = pais)
      }
    })
  }

  cerrarModal() {
    this.marca = new Marca();
    this.marca.pais = {
      idPais: -1
    }
    this.modalService.cerrarModalCrudMarca();
    this.crudMarcaComponent.listarMarca();
  }

  registrar() {
    this.marcaService.create(this.marca).subscribe(response => {
      console.log(this.marca)
      this.modalService.cerrarModalCrudMarca();
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: `Se ha registrado correctamente la marca ${this.marca.nombre}`,
        showConfirmButton: false,
        timer: 2000
      })
    },
      err => {
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: `Error al registrar la marca, ${err.error.mensaje}`,
          showConfirmButton: false
        })
      })
  }

  actualizar() {
    this.marcaService.actualizarMarca(this.marca).subscribe(
      (response) => {
        this.modalService.cerrarModalCrudMarca();
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: `Se ha modificado correctamente la marca ${this.marca.nombre}`,
          showConfirmButton: false,
          timer: 2000
        })
      }),
      (err: { error: { mensaje: any; }; }) => {
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: `Error al actualizar la marca, ${err.error.mensaje}`,
          showConfirmButton: false
        })
      }
  }
}

