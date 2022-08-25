import { Component, OnInit } from '@angular/core';
import { Marca } from 'src/app/models/marca.model';
import { Pais } from 'src/app/models/pais.model';
import { Producto } from 'src/app/models/producto.model';
import { MarcaService } from 'src/app/services/marca.service';
import { PaisService } from 'src/app/services/pais.service';
import { ModalService } from 'src/app/services/modal.service';
import { CrudProductoComponent } from 'src/app/components/crud-producto/crud-producto.component';
import Swal from 'sweetalert2';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-modal-crud-producto',
  templateUrl: './modal-crud.component.html',
  styleUrls: ['./modal-crud.component.css']
})
export class ModalCrudComponentProducto implements OnInit {

  producto: Producto = new Producto();
  titulo: String = "Registrar Producto";
  public pais: Pais[] = [];
  public marca: Marca[] = [];
  public estados = [{ id: 1, descripcion: 'Activo' },
  { id: 0, descripcion: 'Inactivo' }]


  constructor(
    public marcaService: MarcaService,
    public paisService: PaisService,
    public productoService: ProductoService,
    public modalService: ModalService,
    public crudProductoComponent: CrudProductoComponent
  ) { }

  ngOnInit(): void {
    this.escucharAperturaModal();
    this.cargarPais();
    this.cargarMarca();
  }

  cargarPais() {
    this.paisService.listaPais().subscribe(pais => this.pais = pais)
  }

  cargarMarca() {
    this.marcaService.listaMarca().subscribe(marca => this.marca = marca)
  }

  escucharAperturaModal() {
    this.modalService.notificarAbrirModalCrudProducto.subscribe(obj => {
      this.producto = obj;

      if (obj.idProducto == null) {
        this.titulo = "Registrar Producto";
        this.producto.pais = {
          idPais: -1
        }
        this.producto.marca = {
          idMarca: -1
        }
      } else {
        this.titulo = "Editar Producto";

        this.paisService.listaPais().subscribe(pais => this.pais = pais)
        this.marcaService.listaMarca().subscribe(marca => this.marca = marca)
      }
    })
  }

  cerrarModal() {
    this.producto = new Producto();
    this.producto.pais = {
      idPais: -1
    }
    this.producto.marca = {
      idMarca: -1
    }
    this.modalService.cerrarModalCrudProducto();
    this.crudProductoComponent.listarProducto();
  }

  registrar() {
    this.productoService.registrarProducto(this.producto).subscribe(response => {
      console.log(this.producto)
      this.modalService.cerrarModalCrudProducto();
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: `Se ha registrado correctamente el producto ${this.producto.nombre}`,
        showConfirmButton: false,
        timer: 2000
      })
    },
      err => {
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: `Error al registrar el producto, ${err.error.mensaje}`,
          showConfirmButton: false
        })
      })
  }

  actualizar() {
    this.productoService.actualizarProducto(this.producto).subscribe(
      (response) => {
        this.modalService.cerrarModalCrudProducto();
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: `Se ha modificado correctamente el producto ${this.producto.nombre}`,
          showConfirmButton: false,
          timer: 2000
        })
      }),
      (err: { error: { mensaje: any; }; }) => {
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: `Error al actualizar el producto, ${err.error.mensaje}`,
          showConfirmButton: false
        })
      }
  }
}

