import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { MarcaService } from 'src/app/services/marca.service';
import { Marca } from 'src/app/models/marca.model';
import { Pais } from 'src/app/models/pais.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { PaisService } from 'src/app/services/pais.service';
@Component({
  selector: 'app-registra-marca',
  templateUrl: './registra-marca.component.html',
  styleUrls: ['./registra-marca.component.css']
})
export class RegistraMarcaComponent implements OnInit {

  public pais: Pais[] = [];
  public marca: Marca = {
    pais: {
      idPais:-1,
    }
  };
  public titulo: String = 'Crear Marca';
  submitted = false;

  forms: FormGroup = this.formBuilder.group({
    
    pais: ['', [Validators.min(1)]],
  });

  constructor(private marcaService: MarcaService, private paisService: PaisService, private formBuilder: FormBuilder) {
    this.paisService.listaPais().subscribe( pais => this.pais = pais)
   }

  ngOnInit(): void {
  }
  
  public registrarMarca(): void {
    this.submitted = true;
    
    this.marcaService.create(this.marca).subscribe(
      marca => {
        Swal.fire('Registro de Marca', `La Marca ${marca.nombre} ha sido registrada con éxito`, 'success');
      },
      err => {
        Swal.fire('Registro de Marca', `La Marca ${this.marca.nombre} no ha podido ser registrada`, 'error');
      }
    );
  }
}
