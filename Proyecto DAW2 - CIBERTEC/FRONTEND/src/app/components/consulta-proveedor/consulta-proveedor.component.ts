import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Proveedor } from 'src/app/models/proveedor.model';
import { Ubigeo } from 'src/app/models/ubigeo.model';
import { ProveedorService } from 'src/app/services/proveedor.service';

import { UbigeoService } from 'src/app/services/ubigeo.service';

@Component({
  selector: 'app-consulta-proveedor',
  templateUrl: './consulta-proveedor.component.html',
  styleUrls: ['./consulta-proveedor.component.css']
})
export class ConsultaProveedorComponent implements OnInit {

  proveedor: Proveedor[] = [];

  //Ubigeo
  selDepartamento: string = "-1";
  selProvincia: string = "-1";
  selDistrito: number = -1;

  departamentos: string[] = [];
  provincias: string[] = [];
  distritos: Ubigeo[] = [];

  public estados = [{ id: 1, descripcion: 'Activo' },
  { id: 0, descripcion: 'Inactivo' }]

  patternDepartamento = ""
  patternProvincia = ""
  patternDistrito=""
  validDepartamento = new FormControl('valid', [Validators.required, Validators.pattern(this.patternDepartamento)]);
  validProvincia = new FormControl('valid', [Validators.required, Validators.pattern(this.patternProvincia)]);
  validDistrito = new FormControl('valid', [Validators.required, Validators.pattern(this.patternDistrito)]);

  public FiltrarRazonSocial: string = '';
  public FiltrarRuc: string = '';



  selectedEstado: number = 1
  validEstado = new FormControl('valid', [Validators.required, Validators.pattern('[0-2]')]);

  constructor(private ubigeoService: UbigeoService, private proveedorService: ProveedorService) { }

  ngOnInit(): void {
    this.cargarDepartamento()
    this.listarProveedor()

  }
  cargarDepartamento() {
    this.ubigeoService.listarDepartamento().subscribe(
      (x) => {
        this.departamentos = x
        this.patternDepartamento = '(' + x.join('|') + ')'

      }
    );
  }

  cargaProvincia() {
    this.ubigeoService.listaProvincias(this.selDepartamento).subscribe(
      (x) => {
        this.provincias = x
        this.patternProvincia = '(' + x.join('|') + ')'
      }

    );
    this.selProvincia = "-1";
    this.distritos = [];
    this.selDistrito = -1;
    this.listarProveedor()
  }
  cargaDistrito() {
    this.ubigeoService.listaDistritos(this.selDepartamento, this.selProvincia).subscribe(
      (x) => {
        this.distritos = x
        //Ejemplo Internet => this.checklist.filter(x=> x.isSelected).map(y =>{ return y.catItem }).join(", ")
        this.patternDistrito = '(' + x.map(y =>{ return y.idUbigeo }).join("|") + ')'
       
      }
    );

    this.selDistrito = -1;
    this.listarProveedor()
  }

  filtrarUbigeo() {
    this.listarProveedor()
  }

  cambioEstado() {
    this.listarProveedor()
  }
  listarProveedor() {//
    let FiltrarURL = `/Filtrar?razonsocial=${this.FiltrarRazonSocial}&ruc=${this.FiltrarRuc}&estado=${this.selectedEstado}&idUbigeo=${this.selDistrito}`
    this.proveedorService.listarConFiltro(FiltrarURL)
      .subscribe(response => {
        console.log(response)
        this.proveedor = response.lista as Proveedor[];
      });
  }
  compareCategoryObjects(object1: any, object2: any) {
    console.log(object1)
    console.log(object2)
    return object1 && object2 && object1 == object2;
  }

  buscarRazonSocial() {
    this.FiltrarRuc = ''
    this.listarProveedor()
  }
  buscarRuc() {
    this.FiltrarRazonSocial = ''
    this.listarProveedor()
  }
  
}
