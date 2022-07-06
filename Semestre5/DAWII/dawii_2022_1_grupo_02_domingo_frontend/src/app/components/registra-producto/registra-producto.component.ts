import { Component, OnInit } from '@angular/core';
import { Marca } from 'src/app/models/marca.model';
import { Pais } from 'src/app/models/pais.model';
import { Producto } from 'src/app/models/producto.model';
import { MarcaService } from 'src/app/services/marca.service';
import { PaisService } from 'src/app/services/pais.service';
import { ProductoService } from 'src/app/services/producto.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-registra-producto',
  templateUrl: './registra-producto.component.html',
  styleUrls: ['./registra-producto.component.css']
})
export class RegistraProductoComponent implements OnInit {
  
  paises: Pais[]=[]
  marcas: Marca[]=[]

  producto: Producto = new Producto();

  constructor(private productoService: ProductoService,
              private marcaService: MarcaService,
              private paisService: PaisService)

  {

    this.producto = {
        idProducto: 0,
        pais:{
          idPais: -1
        },
        marca: {
          idMarca: -1
        }
      }
    

    this.marcaService.listaMarca()
    .subscribe((data) =>{
      this.marcas = data
      console.log("Lista de Marcas")
      console.log(this.marcas)
    });
    
    this.paisService.listaPais()
    .subscribe((data) =>{
      this.paises = data
      console.log("Lista de Paises")
      console.log(this.paises)
    });
  }

  ngOnInit(): void {

  }

  registrarProducto(){
    console.log("Ingresar a registrar Producto")
    console.log(this.producto)
   this.productoService.registrarProducto(this.producto)
     .subscribe((data) => {
      console.log(data)
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: `${data.message}.`,
        showConfirmButton: false,
        timer: 3500
      })
    },
      err => {
        console.log(err)
        Swal.fire({
          position: 'center',
          icon: 'error',
          title: `Error al registrar el producto - ${err.message}`,
          showConfirmButton: false
        })
        console.error(err)

      }
     )
  }


}
