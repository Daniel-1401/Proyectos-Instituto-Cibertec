import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Marca } from 'src/app/models/marca.model';
import { Pais } from 'src/app/models/pais.model';
import { Producto } from 'src/app/models/producto.model';
import { MarcaService } from 'src/app/services/marca.service';
import { PaisService } from 'src/app/services/pais.service';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-consulta-producto',
  templateUrl: './consulta-producto.component.html',
  styleUrls: ['./consulta-producto.component.css']
})
export class ConsultaProductoComponent implements OnInit {

  paises: Pais[] = []
  marcas: Marca[] = []
  producto: Producto[] = []


  validPais = new FormControl('valid', [Validators.required]);
  validMarca = new FormControl('valid', [Validators.required]);
  validEstado = new FormControl('valid', [Validators.required, Validators.pattern('[0-2]')]);

  public filtroNombre: String = "";
  public selPais: number = -1;
  public selMarca: number = -1;
  public selectedEstado: number = 1;
  public estados = [{ id: 1, descripcion: 'Activo' },
  { id: 0, descripcion: 'Inactivo' }]


  constructor(private productoService: ProductoService, private marcaService: MarcaService, private paisService: PaisService) {

  }

  ngOnInit(): void {
    this.cargarPais();
    this.cargarMarca();
    this.listarProducto();
  }

  cargarPais() {
    this.paisService.listaPais().subscribe(pais => this.paises = pais)
    this.listarProducto();
  }

  cargarMarca() {
    this.marcaService.listaMarca().subscribe(marca => this.marcas = marca)
    this.listarProducto();
  }
  listarProducto() {
    let filtroURL = `/filtro?nombre=${this.filtroNombre}&pais=${this.selPais}&estado=${this.selectedEstado}&marca=${this.selMarca}`;
    this.productoService.listarFiltro(filtroURL).subscribe(response => this.producto = response.lista as Producto[])
  }
  cambioEstado() {
    this.listarProducto();
  }
  buscarNombre() {
    this.listarProducto();

  }
}
