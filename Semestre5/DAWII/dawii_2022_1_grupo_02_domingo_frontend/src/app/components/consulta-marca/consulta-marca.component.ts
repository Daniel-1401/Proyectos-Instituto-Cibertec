import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Marca } from 'src/app/models/marca.model';
import { Pais } from 'src/app/models/pais.model';
import { MarcaService } from 'src/app/services/marca.service';
import { PaisService } from 'src/app/services/pais.service';

@Component({
  selector: 'app-consulta-marca',
  templateUrl: './consulta-marca.component.html',
  styleUrls: ['./consulta-marca.component.css']
})
export class ConsultaMarcaComponent implements OnInit {

  
  public pais: Pais[] = [];
  public marca: Marca[] = [];
  //private patternPaises = "";
  validPais = new FormControl('valid', [Validators.required]);
  validEstado = new FormControl('valid', [Validators.required, Validators.pattern('[0-2]')]);

  public filtroNombre: String = "";
  public filtroDescripcion: String = "";
  public selPais: number = -1;
  public selectedEstado: number = 1;
  public estados = [{ id: 1, descripcion: 'Activo' },
  { id: 0, descripcion: 'Inactivo' }]

  constructor(private paisService: PaisService, private marcaService: MarcaService) {
   }

  ngOnInit(): void {
    this.cargarPais();
    this.listarMarca();
  }

  cargarPais() {
    this.paisService.listaPais().subscribe( pais => this.pais = pais)
    this.listarMarca();
  }

  buscarNombre(){
    this.listarMarca();
    
  }

  listarMarca(){
    let filtroURL = `/filtro?nombre=${this.filtroNombre}&pais=${this.selPais}&estado=${this.selectedEstado}&descripcion=${this.filtroDescripcion}`;

    this.marcaService.listarFiltro(filtroURL).subscribe( response => this.marca = response.lista as Marca[])

  }

  cambioEstado(){
    this.listarMarca();
  }

  buscarDescripcion(){
    this.listarMarca();
  }
}