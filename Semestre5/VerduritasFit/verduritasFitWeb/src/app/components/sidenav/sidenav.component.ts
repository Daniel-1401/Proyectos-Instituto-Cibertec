import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/Services/auth.service';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.css']
})
export class SidenavComponent implements OnInit {

  showFiller = true;
  panelOpenState = false;
  public appPages = [ 
    { name: 'Categorías', url: '/categoria', icon: 'file-tray-full' },
  ];
  public appPagesTwo = [
    { title: 'Login', url: '/login', icon: 'finger-print' },
  ]

  constructor(public authService: AuthService) { }

  ngOnInit(): void {
  }

}
