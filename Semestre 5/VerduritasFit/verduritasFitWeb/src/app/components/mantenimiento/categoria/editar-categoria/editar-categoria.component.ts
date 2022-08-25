import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/Services/auth.service';
import { Router, ActivatedRoute } from '@angular/router';
import { CategoriaService } from 'src/app/Services/categoria.service';
import { Categoria } from 'src/app/Models/Categoria';

@Component({
  selector: 'app-editar-categoria',
  templateUrl: './editar-categoria.component.html',
  styleUrls: ['./editar-categoria.component.css']
})
export class EditarCategoriaComponent implements OnInit {

  categoria: Categoria={
    id_categoria: 0,
    nombre_categoria: "",
  };
  constructor(public authService: AuthService,
              public categoriaService: CategoriaService,
              private router: Router,
              private activatedRoute: ActivatedRoute,) { }

  ngOnInit(): void {
    if(!this.authService.isAutenticado){
      this.router.navigate(['/login']);
    }else{
      this.activatedRoute.paramMap.subscribe((paramMap) => {
        if (paramMap.get("idCategoria")) {
          this.categoria.id_categoria=parseInt(paramMap.get("idCategoria")!);
          this.categoriaService.buscarCategoria(this.categoria.id_categoria).subscribe((data:any) => {
            this.categoria = data.result;
            console.log(this.categoria)
          });
        }
      });
    }
  }
  actualizarCategoria(){
    this.categoriaService.actualizarCategoria(this.categoria)
    .subscribe((data:any) => {
      this.router.navigate(['mantenimientoCategoria']);
    });
  }

}
