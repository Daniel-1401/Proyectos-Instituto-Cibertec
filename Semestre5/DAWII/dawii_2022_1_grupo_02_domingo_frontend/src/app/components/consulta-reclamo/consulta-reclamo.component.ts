import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {MatDatepicker, MatDatepickerModule} from '@angular/material/datepicker';
import { Reclamo } from 'src/app/models/reclamo.model';
import { Cliente } from 'src/app/models/cliente.model';
import { TipoReclamo } from 'src/app/models/tipo-reclamo.model';
import { ReclamoService } from 'src/app/services/reclamo.service';
import { ClienteService } from 'src/app/services/cliente.service';
import { TipoReclamoService } from 'src/app/services/tipo-reclamo.service';

@Component({
  selector: 'app-consulta-reclamo',
  templateUrl: './consulta-reclamo.component.html',
  styleUrls: ['./consulta-reclamo.component.css']
})
export class ConsultaReclamoComponent implements OnInit {
  
  range = new FormGroup({
    start: new FormControl(),
    end: new FormControl(),
  });
  reclamos: Reclamo[] = [];


  clientes: Cliente[] = [];
  tiposReclamo: TipoReclamo[] = []

  public estados = [
                    {id: 1, descripcion: 'Activo'},
                    {id: 0, descripcion: 'Inactivo'},
                  ]
  public filtroDescripcion: String = '';
  public filtroFechaRegistro: String = '';
  public filtroRangoInicialFecha: String = '';
  public filtroRangoFinalFecha: String = '';

  selCliente: String = "-1";
  selTipoReclamo: String = "-1";

  selectedEstado: number = 1;

  validEstado = new FormControl('valid', [Validators.required, Validators.pattern('[0-1]')]);
  

  constructor(private reclamoService: ReclamoService,
              private clienteService: ClienteService,
              private tipoReclamo: TipoReclamoService) { }

  ngOnInit(): void {
    this.listarReclamos()
    this.obtenerClientes()
    this.obtenerTiposReclamos()
  }
  listarReclamos() {
    // console.log(this.filtroDescripcion)
    // console.log(this.filtroFechaRegistro)
    // console.log(this.filtroRangoInicialFecha)
    // console.log(this.filtroRangoFinalFecha)
    // console.log(this.selectedEstado)
    // console.log(this.selCliente)
    // console.log(this.selTipoReclamo)
    let filtroURL = `/filtro?` +
                    `descripcion=${this.filtroDescripcion}` +
                    `&fechaRegistro=${this.filtroFechaRegistro}` +
                    `&rangoInicioFecha=${this.filtroRangoInicialFecha}` +
                    `&rangoFinFecha=${this.filtroRangoFinalFecha}` +
                    `&estado=${this.selectedEstado}` +
                    `&idCliente=${this.selCliente}` +
                    `&idTipoReclamo=${this.selTipoReclamo}`
    this.reclamoService.listarConFiltro(filtroURL).subscribe((data) =>{
      //console.log("Data reclamos -> ",data)
      this.reclamos = data.lista
      // console.log("Reclamos -> ",this.reclamos)
    })
  }
  obtenerClientes() {
    this.clienteService.listaCliente().subscribe((data) => {
      //console.log("Data clientes ->",data)
      this.clientes = data
      // console.log("Clientes -> ",this.clientes)
    })
  }
  obtenerTiposReclamos() {
    this.tipoReclamo.listaTipoReclamo().subscribe((data)=>{
      //console.log("Data Tipos Reclamo -> ", data)
      this.tiposReclamo = data
      // console.log("Tipos reclamos -> ", this.tiposReclamo)
    })
  }
  buscarDescripcionClienteTipoReclamo(){
    this.filtroFechaRegistro = ""
    this.filtroRangoInicialFecha = ""
    this.filtroRangoFinalFecha = ""
    // console.log("Descripcion -> ",this.filtroDescripcion)
    // console.log("Cliente seleccionado ->",this.selCliente)
    // console.log("Tipo reclamo seleccionado ->",this.selTipoReclamo)
    // console.log("Estado seleccionado ->",this.selectedEstado)
    this.listarReclamos();
  }
  buscarFechaRegistro(){
    this.filtroRangoInicialFecha = "";
    this.filtroRangoFinalFecha = "";
  }
  buscarRangoFechas(){
  
    this.range.reset()
    this.filtroFechaRegistro = ""
    // console.log("Entre en rango fechas")
  }
  obtenerFechaInicial(){
    let fecha: Date;
    // console.log("ENTRE EN OBTENER FECHA INICIAL")
    fecha = this.range.value.start
    this.filtroRangoInicialFecha = `${fecha.getFullYear()}-${fecha.getMonth() + 1}-${fecha.getDate()}`
    // console.log("FECHA INICIAL FORMATEADA ->", this.filtroRangoInicialFecha)
  }
  obtenerFechaFinal(){
    let fecha: Date;
    // console.log("ENTRE EN OBTENER FECHA FINAL")
    fecha = this.range.value.end
    this.filtroRangoFinalFecha = `${fecha.getFullYear()}-${fecha.getMonth() + 1}-${fecha.getDate()}`
    // console.log("FECHA FINAL FORMATEADA ->", this.filtroRangoFinalFecha)
    this.listarReclamos()
  }
}
