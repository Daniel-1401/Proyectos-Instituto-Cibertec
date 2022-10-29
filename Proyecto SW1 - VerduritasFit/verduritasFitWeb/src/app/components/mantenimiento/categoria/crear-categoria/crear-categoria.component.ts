import { Categoria } from 'src/app/Models/Categoria';
import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/Services/auth.service';
import { Router } from '@angular/router';
import { CategoriaService } from 'src/app/Services/categoria.service';

@Component({
  selector: 'app-crear-categoria',
  templateUrl: './crear-categoria.component.html',
  styleUrls: ['./crear-categoria.component.css']
})
export class CrearCategoriaComponent implements OnInit {

  categoria: Categoria={
    nombre_categoria: "",
  };

  constructor(public authService: AuthService,
              public categoriaService: CategoriaService,
              private router: Router) { }

  ngOnInit(): void {
    if(!this.authService.isAutenticado){
        this.router.navigate(['/login']);
      }
  }

  crearCategoria(){
    console.log(this.categoria);
    this.categoriaService.crearCategoria(this.categoria).subscribe((data: any) => {
      this.router.navigate(['mantenimientoCategoria']);
    },
    (errorData) => alert(errorData.error.displayMessage));
  }

}
