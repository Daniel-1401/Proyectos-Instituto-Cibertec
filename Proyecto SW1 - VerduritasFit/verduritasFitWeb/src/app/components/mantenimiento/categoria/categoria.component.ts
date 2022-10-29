import { CategoriaService } from './../../../Services/categoria.service';
import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { Categoria } from 'src/app/Models/Categoria';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-categoria',
  templateUrl: './categoria.component.html',
  styleUrls: ['./categoria.component.css']
})
export class CategoriaComponent implements OnInit {
  displayedColumns: string[] = ['id_categoria', 'nombre_categoria', 'action'];

  categorias: Categoria[] = [];

  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private categoriaServise: CategoriaService) { }
  ngOnInit(): void {
    this.loadCategoria();
  }

  loadCategoria(){
    this.categoriaServise.listarCategoria().subscribe((data: any) =>{
      this.categorias = data.result;
      console.log("categoria",this.categorias)
    })
  }

  eliminar(id: number) {
    Swal.fire({
      title: 'Está seguro que desea eliminar?',
      text: "No se va a poder revertir!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, Eliminar!'
    }).then((result) => {
      if (result.isConfirmed) {
        this.categoriaServise.eliminarCategoria(id).subscribe(
          (x) => {
            this.loadCategoria()
            Swal.fire(
              'Eliminado!',
              'Elimando Correctamente.',
              'success'
            )
          },
          err => {
            console.log(err)
            Swal.fire({
              position: 'center',
              icon: 'error',
              title: `${err.error.message}`,
              text: `${err.error.data}`,
              showConfirmButton: false
            })
            console.error(err)
  
          }
        );
      }
    })
  }

  editar(id:number){
    
  }

}
