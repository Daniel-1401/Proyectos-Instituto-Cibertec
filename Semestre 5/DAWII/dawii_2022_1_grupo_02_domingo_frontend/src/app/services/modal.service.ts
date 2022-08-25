import { EventEmitter, Injectable } from '@angular/core';
import { Cliente } from '../models/cliente.model';
import { Marca } from '../models/marca.model';
import { Producto } from '../models/producto.model';
import { Proveedor } from '../models/proveedor.model';
import { Reclamo } from '../models/reclamo.model';

@Injectable({
  providedIn: 'root'
})
export class ModalService {
  switchModalCrudCliente:boolean=false;
  switchModalCrudMarca:boolean=false;
  switchModalCrudProveedor:boolean=false;
  switchModalCrudReclamo:boolean=false;
  switchModalCrudProducto:boolean=false;

  
  private _notificarAbrirModalCrudCliente=new EventEmitter<any>();
  private _notificarCerrarModalCrudCliente=new EventEmitter<any>();

  private _notificarAbrirModalCrudMarca = new EventEmitter<any>();
  private _notificarCerrarModalCrudMarca = new EventEmitter<any>();

  private _notificarAbrirModalCrudProveedor=new EventEmitter<any>();
  private _notificarCerrarModalCrudProveedor=new EventEmitter<any>();

  private _notificarAbrirModalCrudReclamo=new EventEmitter<any>();
  private _notificarCerrarModalCrudReclamo=new EventEmitter<any>();

  private _notificarAbrirModalCrudProducto=new EventEmitter<any>();
  private _notificarCerrarModalCrudProducto=new EventEmitter<any>();

  get notificarAbrirModalCrudCliente():EventEmitter<any>{
    return this._notificarAbrirModalCrudCliente
  }
  get notificarCerrarModalCrudCliente():EventEmitter<any>{
    return this._notificarCerrarModalCrudCliente
  }

  get notificarAbrirModalCrudMarca():EventEmitter<any>{
    return this._notificarAbrirModalCrudMarca
  }
  get notificarCerrarModalCrudMarca():EventEmitter<any>{
    return this._notificarCerrarModalCrudMarca
  }

  get notificarAbrirModalCrudProveedor():EventEmitter<any>{
    return this._notificarAbrirModalCrudProveedor
  }
  get notificarCerrarModalCrudProveedor():EventEmitter<any>{
    return this._notificarCerrarModalCrudProveedor
  }

  get notificarAbrirModalCrudReclamo():EventEmitter<any>{
    return this._notificarAbrirModalCrudReclamo
  }
  get notificarCerrarModalCrudReclamo():EventEmitter<any>{
    return this._notificarCerrarModalCrudReclamo
  }

  get notificarAbrirModalCrudProducto():EventEmitter<any>{
    return this._notificarAbrirModalCrudProducto
  }
  get notificarCerrarModalCrudProducto():EventEmitter<any>{
    return this._notificarCerrarModalCrudProducto
  }
  
  constructor() { }

  abrirModalCrudCliente(cli:Cliente){
    this.switchModalCrudCliente=true
    this._notificarAbrirModalCrudCliente.emit(cli)
  }

  cerrarModalCrudCliente(){
    this.switchModalCrudCliente=false
    this._notificarCerrarModalCrudCliente.emit()
  }


  abrirModalCrudMarca(marca:Marca){
    this.switchModalCrudMarca = true
    this._notificarAbrirModalCrudMarca.emit(marca)
  }

  cerrarModalCrudMarca(){
    this.switchModalCrudMarca = false
    this._notificarCerrarModalCrudMarca.emit()
  }


  abrirModalCrudProveedor(pro:Proveedor){
    this.switchModalCrudProveedor = true
    this._notificarAbrirModalCrudProveedor.emit(pro)
  }
  cerrarModalCrudProveedor(){
    this.switchModalCrudProveedor = false
    this._notificarCerrarModalCrudProveedor.emit()
  }
  

  abrirModalCrudReclamo(reclamo:Reclamo){
    this.switchModalCrudReclamo = true
    this._notificarAbrirModalCrudReclamo.emit(reclamo)
  }
  cerrarModalCrudReclamo(){
    this.switchModalCrudReclamo = false
    this._notificarCerrarModalCrudReclamo.emit()
  }

  abrirModalCrudProducto(producto:Producto){
    this.switchModalCrudProducto=true
    this._notificarAbrirModalCrudProducto.emit(producto)
  }

  cerrarModalCrudProducto(){
    this.switchModalCrudProducto=false
    this._notificarCerrarModalCrudProducto.emit()
  }

}
