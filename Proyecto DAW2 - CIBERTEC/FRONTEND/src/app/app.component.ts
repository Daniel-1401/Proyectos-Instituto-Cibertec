import { FirestoreService } from './services/firestore.service';
import { AuthService } from 'src/app/services/auth.service';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { map } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'Sistema de DAWII - Jacinto';
  login: boolean = false;
  nombre: string = null!;
  rol:
    | 'admin'
    | 'cliente'
    | 'marca'
    | 'producto'
    | 'proveedor'
    | 'reclamo'
    | 'sede' = null!;

  constructor(
    http: HttpClient,
    private authService: AuthService,
    private firestoreService: FirestoreService,
    private router: Router
  ) {
    this.authService.stateUser().subscribe((res) => {
      if (res) {
        console.log('loged');
        this.login = true;
        this.getDatosUser(res.uid);
      } else {
        console.log('no loged');
        this.login = false;
      }
    });
  }

  logout() {
    this.authService
      .logout()
      .then(() => {
        this.login = false;
        this.nombre = null!;
        window.location.reload();
      })
      .catch((error) => console.log(error));
  }

  getDatosUser(uid: string) {
    this.firestoreService.getUserById(uid).subscribe((res) => {
      console.log('datos ->', res);
      if(res){
        this.rol = res.perfil!;
      this.nombre = res.nombre!;      }
    });
  }
}
