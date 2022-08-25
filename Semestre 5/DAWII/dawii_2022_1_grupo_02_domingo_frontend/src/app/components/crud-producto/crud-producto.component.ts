import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Marca } from 'src/app/models/marca.model';
import { Pais } from 'src/app/models/pais.model';
import { Producto } from 'src/app/models/producto.model';
import { MarcaService } from 'src/app/services/marca.service';
import { PaisService } from 'src/app/services/pais.service';
import { ProductoService } from 'src/app/services/producto.service';
import { ModalService } from 'src/app/services/modal.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-crud-producto',
  templateUrl: './crud-producto.component.html',
  styleUrls: ['./crud-producto.component.css']
})
export class CrudProductoComponent implements OnInit {

  public pais: Pais[] = [];
  public marca: Marca[] = [];
  public producto: Producto[] = [];
  validPais = new FormControl('valid', [Validators.required]);
  validMarca = new FormControl('valid', [Validators.required]);
  validEstado = new FormControl('valid', [Validators.required, Validators.pattern('[0-2]')]);
  public filtroNombre: String = "";
  public selPais: number = -1;
  public selMarca: number = -1;
  public selectedEstado: number = 1;
  public estados = [{ id: 1, descripcion: 'Activo' },
  { id: 0, descripcion: 'Inactivo' }]

  constructor(private paisService: PaisService, private marcaService: MarcaService, private productoService: ProductoService, public modalService:ModalService) { }

  ngOnInit(): void {
    this.escucharCierreModalProducto();
    this.cargarPais();
    this.cargarMarca();
    this.listarProducto();
  }

  escucharCierreModalProducto(){
    this.modalService.notificarCerrarModalCrudProducto.subscribe( () => {
      this.listarProducto();
    })
  }

  cargarPais() {
    this.paisService.listaPais().subscribe( pais => this.pais = pais)
    
  }

  cargarMarca() {
    this.marcaService.listaMarca().subscribe( marca => this.marca = marca)
    
  }
  
  listarProducto(){
    let filtroURL = `/filtro?nombre=${this.filtroNombre}&pais=${this.selPais}&estado=${this.selectedEstado}&marca=${this.selMarca}`;

    this.productoService.listarFiltro(filtroURL).subscribe( response => this.producto = response.lista as Producto[])

  }
  buscarNombre(){
    this.listarProducto();
    
  }
  buscarEstado(){
    this.listarProducto();
  }

  registrar(){
    let producto = new Producto()
    this.modalService.abrirModalCrudProducto(producto);
  }

  actualizar(producto:Producto){
    this.modalService.abrirModalCrudProducto(producto);
  }

  cambiarActive(producto:Producto){
    producto.estado = producto.estado == 1 ? 0 : 1;
    this.productoService.actualizarProducto(producto).subscribe( response => { this.listarProducto()})
  }

  eliminar(producto:Producto){
    Swal.fire({
      title: '¿Está seguro que desea eliminar?',
      text: "¡Esta acción no se puede revertir!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Sí, eliminar'
    }).then( result => { 
      if (result.isConfirmed) {
        this.productoService.eliminarProducto(producto).subscribe( 
          x => {
            this.listarProducto();
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
    this.listarProducto();
  }
}
