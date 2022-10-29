import { CrearCategoriaComponent } from './components/mantenimiento/categoria/crear-categoria/crear-categoria.component';
import { EditarCategoriaComponent } from './components/mantenimiento/categoria/editar-categoria/editar-categoria.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TiendaComponent } from './components/tienda/tienda.component';
import { CategoriaComponent } from './components/mantenimiento/categoria/categoria.component';
import { ObjetivoComponent } from './components/mantenimiento/objetivo/objetivo.component';
import { PedidoComponent } from './components/mantenimiento/pedido/pedido.component';
import { PlatilloComponent } from './components/mantenimiento/platillo/platillo.component';
import { UsuarioComponent } from './components/mantenimiento/usuario/usuario.component';
import { LoginComponent } from './components/usuario/login/login.component';
import { RegisterComponent } from './components/usuario/register/register.component';
import { MantenimientoComponent } from './components/mantenimiento/mantenimiento.component';

const routes: Routes = [
  {
    path: '',
    component: TiendaComponent 
  },
  {
    path: 'tienda',
    component: TiendaComponent 
  },
  {
    path: 'mantenimientoCategoria',
    component: CategoriaComponent 
  },
  {
    path: 'editCategoria/:idCategoria',
    component: EditarCategoriaComponent
  },
  {
    path: 'crearCategoria',
    component: CrearCategoriaComponent
  },
  {
    path: 'mantenimientoObjetivo',
    component: ObjetivoComponent 
  },
  {
    path: 'mantenimientoPedido',
    component: PedidoComponent 
  },
  {
    path: 'mantenimientoPlatillo',
    component: PlatilloComponent 
  },
  {
    path: 'mantenimientoUsuario',
    component: UsuarioComponent 
  },
  {
    path: 'login',
    component: LoginComponent 
  },
  {
    path: 'register',
    component: RegisterComponent 
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
