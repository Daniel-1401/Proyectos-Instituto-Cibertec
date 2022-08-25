import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Marca } from 'src/app/models/marca.model';
import { Pais } from 'src/app/models/pais.model';
import { MarcaService } from 'src/app/services/marca.service';
import { PaisService } from 'src/app/services/pais.service';
import { ModalService } from 'src/app/services/modal.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-crud-marca',
  templateUrl: './crud-marca.component.html',
  styleUrls: ['./crud-marca.component.css']
})
export class CrudMarcaComponent implements OnInit {

  public pais: Pais[] = [];
  public marca: Marca[] = [];
  validPais = new FormControl('valid', [Validators.required]);
  validEstado = new FormControl('valid', [Validators.required, Validators.pattern('[0-2]')]);
  public filtroNombre: String = "";
  public filtroDescripcion: String = "";
  public selPais: number = -1;
  public selectedEstado: number = 1;
  public estados = [{ id: 1, descripcion: 'Activo' },
  { id: 0, descripcion: 'Inactivo' }]

  constructor(private paisService: PaisService, private marcaService: MarcaService, public modalService:ModalService) { }

  ngOnInit(): void {
    this.escucharCierreModalMarca();
    this.cargarPais();
    this.listarMarca();
  }

  escucharCierreModalMarca(){
    this.modalService.notificarCerrarModalCrudMarca.subscribe( () => {
      this.listarMarca();
    })
  }

  cargarPais() {
    this.paisService.listaPais().subscribe( pais => this.pais = pais)
    
  }
  listarMarca(){
    let filtroURL = `/filtro?nombre=${this.filtroNombre}&pais=${this.selPais}&estado=${this.selectedEstado}&descripcion=${this.filtroDescripcion}`;

    this.marcaService.listarFiltro(filtroURL).subscribe( response => this.marca = response.lista as Marca[])

  }
  buscarNombre(){
    this.listarMarca();
    
  }
  buscarEstado(){
    this.listarMarca();
  }

  registrar(){
    let mar = new Marca()
    this.modalService.abrirModalCrudMarca(mar);
  }

  actualizar(mar:Marca){
    this.modalService.abrirModalCrudMarca(mar);
  }

  cambiarActive(mar:Marca){
    mar.estado = mar.estado == 1 ? 0 : 1;
    this.marcaService.actualizarMarca(mar).subscribe( response => { this.listarMarca()})
  }

  eliminar(mar:Marca){
    Swal.fire({
      title: 'Está seguro que desea eliminar?',
      text: "No se va a poder revertir!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, Eliminar!'
    }).then( result => { 
      if (result.isConfirmed) {
        this.marcaService.eliminarMarca(mar).subscribe( 
          x => {
            this.listarMarca();
            Swal.fire(
              'Eliminado!',
              'El registro ha sido eliminado.',
              'success'
            )
          },
          err => {
            Swal.fire({
              position: 'center',
              icon: 'error',
              title: `${err.error.message}`,
              text: `${err.error.data}`,
              showConfirmButton: false
            })
          }
        )
      }
    }),
    this.listarMarca();
  }
}
