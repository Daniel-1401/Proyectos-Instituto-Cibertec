import { PlatilloService } from './../../../Services/platillo.service';
import { Component, OnInit } from '@angular/core';
import { Platillo } from 'src/app/Models/Platillo';

@Component({
  selector: 'app-platillo',
  templateUrl: './platillo.component.html',
  styleUrls: ['./platillo.component.css']
})
export class PlatilloComponent implements OnInit {

  platillo: Platillo[] = [];

  constructor(private platilloService: PlatilloService) { }

  ngOnInit(): void {
    this.loadPlatillos();
  }
  loadPlatillos() {
    this.platilloService.listarPlatillos().subscribe((data: any) =>{
      this.platillo = data.result;
      console.log("platillo",this.platillo)
    })
  }

}
