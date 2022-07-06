import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AuthService } from './Services/auth.service';
import { CategoriaComponent } from './components/mantenimiento/categoria/categoria.component';
import { ObjetivoComponent } from './components/mantenimiento/objetivo/objetivo.component';
import { PedidoComponent } from './components/mantenimiento/pedido/pedido.component';
import { PlatilloComponent } from './components/mantenimiento/platillo/platillo.component';
import { UsuarioComponent } from './components/mantenimiento/usuario/usuario.component';
import { TiendaComponent } from './components/tienda/tienda.component';
import { LoginComponent } from './components/usuario/login/login.component';
import { RegisterComponent } from './components/usuario/register/register.component';
import { SidenavComponent } from './components/sidenav/sidenav.component';
import { MantenimientoComponent } from './components/mantenimiento/mantenimiento.component';
import { DetalleComponent } from './components/tienda/detalle/detalle.component';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatSliderModule } from '@angular/material/slider';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { MatMenuModule } from '@angular/material/menu';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatSelectModule} from '@angular/material/select';
import {MatCardModule} from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatTableModule} from '@angular/material/table';
import { EditarCategoriaComponent } from './components/mantenimiento/categoria/editar-categoria/editar-categoria.component';
import { CrearCategoriaComponent } from './components/mantenimiento/categoria/crear-categoria/crear-categoria.component';

@NgModule({
  declarations: [
    AppComponent,
    CategoriaComponent,
    ObjetivoComponent,
    PedidoComponent,
    PlatilloComponent,
    UsuarioComponent,
    TiendaComponent,
    LoginComponent,
    RegisterComponent,
    SidenavComponent,
    MantenimientoComponent,
    DetalleComponent,
    EditarCategoriaComponent,
    CrearCategoriaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatSliderModule,
    MatSidenavModule,
    MatListModule,
    MatMenuModule,
    MatExpansionModule,
    MatSelectModule,
    MatCardModule,
    MatInputModule,
    MatPaginatorModule,
    MatTableModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
