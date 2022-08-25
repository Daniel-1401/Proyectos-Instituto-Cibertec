import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Cliente } from 'src/app/models/cliente.model';
import { UbigeoService } from 'src/app/services/ubigeo.service';
import { ClienteService } from 'src/app/services/cliente.service';
import { Ubigeo } from 'src/app/models/ubigeo.model';




@Component({
  selector: 'app-consulta-cliente',
  templateUrl: './consulta-cliente.component.html',
  styleUrls: ['./consulta-cliente.component.css']
})
export class ConsultaClienteComponent implements OnInit {
  clientes: Cliente[] = [];

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

  public filtroNombre: string = '';
  public filtroDni: string = '';
  public filtroCorreo: string = '';



  selectedEstado: number = 1
  validEstado = new FormControl('valid', [Validators.required, Validators.pattern('[0-2]')]);

  constructor(private ubigeoService: UbigeoService, private clienteService: ClienteService) { }

  ngOnInit(): void {
    this.cargarDepartamento()
    this.listarCliente()

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
    this.listarCliente()
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
    this.listarCliente()
  }

  filtrarUbigeo() {
    this.listarCliente()
  }

  cambioEstado() {
    this.listarCliente()
  }
  listarCliente() {//
    let filtroURL = `/filtro?nombre=${this.filtroNombre}&correo=${this.filtroCorreo}&dni=${this.filtroDni}&estado=${this.selectedEstado}&idUbigeo=${this.selDistrito}`

    this.clienteService.listarConFiltro(filtroURL)
      .subscribe(response => {
        console.log(response)
        this.clientes = response.lista as Cliente[];
      });
  }
  compareCategoryObjects(object1: any, object2: any) {
    console.log(object1)
    console.log(object2)
    return object1 && object2 && object1 == object2;
  }

  buscarNombre() {
    this.filtroDni = ''
    this.filtroCorreo = ''
    this.listarCliente()
  }
  buscarDNI() {
    this.filtroNombre = ''
    this.filtroCorreo = ''
    this.listarCliente()
  }
  buscarCorreo() {
    this.filtroNombre = ''
    this.filtroDni = ''
    this.listarCliente()
  }
}
