import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { RegistraClienteComponent } from './components/registra-cliente/registra-cliente.component';
import { RegistraMarcaComponent } from './components/registra-marca/registra-marca.component';
import { RegistraProductoComponent } from './components/registra-producto/registra-producto.component';
import { RegistraProveedorComponent } from './components/registra-proveedor/registra-proveedor.component';
import { RegistraReclamoComponent } from './components/registra-reclamo/registra-reclamo.component';
import { RegistraSedeComponent } from './components/registra-sede/registra-sede.component';
import { RegistraUsuarioComponent } from './components/registra-usuario/registra-usuario.component';
import { CrudClienteComponent } from './components/crud-cliente/crud-cliente.component';
import { CrudMarcaComponent } from './components/crud-marca/crud-marca.component';
import { CrudProductoComponent } from './components/crud-producto/crud-producto.component';
import { CrudProveedorComponent } from './components/crud-proveedor/crud-proveedor.component';
import { CrudReclamoComponent } from './components/crud-reclamo/crud-reclamo.component';
import { CrudSedeComponent } from './components/crud-sede/crud-sede.component';
import { CrudUsuarioComponent } from './components/crud-usuario/crud-usuario.component';
import { ConsultaClienteComponent } from './components/consulta-cliente/consulta-cliente.component';
import { ConsultaMarcaComponent } from './components/consulta-marca/consulta-marca.component';
import { ConsultaProductoComponent } from './components/consulta-producto/consulta-producto.component';
import { ConsultaProveedorComponent } from './components/consulta-proveedor/consulta-proveedor.component';
import { ConsultaReclamoComponent } from './components/consulta-reclamo/consulta-reclamo.component';
import { ConsultaSedeComponent } from './components/consulta-sede/consulta-sede.component';
import { ConsultaUsuarioComponent } from './components/consulta-usuario/consulta-usuario.component';
import { ConsultaPedidoComponent } from './components/consulta-pedido/consulta-pedido.component';
import { ConsultaComprobanteComponent } from './components/consulta-comprobante/consulta-comprobante.component';
import { TransaccionPedidoComponent } from './components/transaccion-pedido/transaccion-pedido.component';
import { TransaccionComprobanteComponent } from './components/transaccion-comprobante/transaccion-comprobante.component';
import { LoginComponent } from './components/usuario/login/login.component';
import { RegisterComponent } from './components/usuario/register/register.component';
import { PrincipalComponent } from './components/principal/principal.component';
import { canActivate, redirectUnauthorizedTo } from '@angular/fire/auth-guard';
import { AuthGuard } from './guards/auth.guard';

const routes: Routes = [
  {path:'', pathMatch: 'full', redirectTo:'/principal'},
  // {
  //   path:"principal", 
  //   data:{
  //     role: 'admin'
  //   },
  //   canActivate: [AuthGuard],
  //   component:PrincipalComponent
  // },
  {
    path:"principal", component:PrincipalComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))
  },
  {path:"registraCliente", component:RegistraClienteComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},
  {path:"registraMarca", component:RegistraMarcaComponent,...canActivate(() => redirectUnauthorizedTo(['/login'])) },
  {path:"registraProducto", component:RegistraProductoComponent,...canActivate(() => redirectUnauthorizedTo(['/login'])) },
  {path:"registraProveedor", component:RegistraProveedorComponent,...canActivate(() => redirectUnauthorizedTo(['/login'])) },
  {path:"registraReclamo", component:RegistraReclamoComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},
  {path:"registraSede", component:RegistraSedeComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},
  {path:"registraUsuario", component:RegistraUsuarioComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},

  {path:"crudCliente", component:CrudClienteComponent,...canActivate(() => redirectUnauthorizedTo(['/login'])) },
  {path:"crudMarca", component:CrudMarcaComponent,...canActivate(() => redirectUnauthorizedTo(['/login'])) },
  {path:"crudProducto", component:CrudProductoComponent,...canActivate(() => redirectUnauthorizedTo(['/login'])) },
  {path:"crudProveedor", component:CrudProveedorComponent,...canActivate(() => redirectUnauthorizedTo(['/login'])) },
  {path:"crudReclamo", component:CrudReclamoComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},
  {path:"crudSede", component:CrudSedeComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},
  {path:"crudUsuario", component:CrudUsuarioComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},

  {path:"consultaCliente", component:ConsultaClienteComponent,...canActivate(() => redirectUnauthorizedTo(['/login'])) },
  {path:"consultaMarca", component:ConsultaMarcaComponent,...canActivate(() => redirectUnauthorizedTo(['/login'])) },
  {path:"consultaProducto", component:ConsultaProductoComponent,...canActivate(() => redirectUnauthorizedTo(['/login'])) },
  {path:"consultaProveedor", component:ConsultaProveedorComponent,...canActivate(() => redirectUnauthorizedTo(['/login'])) },
  {path:"consultaReclamo", component:ConsultaReclamoComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},
  {path:"consultaSede", component:ConsultaSedeComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},
  {path:"consultaUsuario", component:ConsultaUsuarioComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},
  {path:"consultaPedido", component:ConsultaPedidoComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},
  {path:"consultaComprobante", component:ConsultaComprobanteComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},

  {path:"registraPedido", component:TransaccionPedidoComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},
  {path:"registraComprobante", component:TransaccionComprobanteComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},

  {path:"login", component:LoginComponent},
  {path:"register", component:RegisterComponent,...canActivate(() => redirectUnauthorizedTo(['/login']))},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {


}
