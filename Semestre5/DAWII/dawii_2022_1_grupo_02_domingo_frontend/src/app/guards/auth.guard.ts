import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from '../services/auth.service';
import { map } from 'rxjs/operators';
import { FirestoreService } from '../services/firestore.service';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  
  rolUsuario: string = null!;

  constructor(
    private auth: AuthService,
    private router: Router,
    private firestoreService: FirestoreService
  ) {}
  canActivate(route: ActivatedRouteSnapshot): Observable<boolean> | boolean{


    return this.auth.userData$.pipe(
      map((user) => {
        if (!user) {
          console.log('entre aquí');

          this.router.navigate(['/login']);
          return false;
        } else {
          console.log('logueado');
          this.getDatosUser(user.uid)
          return this.checkUserLogin(route,user.uid);
        }
      })
    );
  }

  checkUserLogin(route: ActivatedRouteSnapshot, uid: string): boolean {
    let logeado: boolean = false;
    let roleIntro: string = route.data['role'];
    console.log(route.data['role']);
    
    
    this.auth.userData$.pipe(
      map((user) => {
        if (!user) {
          console.log('entre aquí');

          this.router.navigate(['/login']);
          logeado = false;
        } else {
          console.log('logueado');
          this.firestoreService.getUserById(user.uid).subscribe((res) => {
            console.log('datos ->', res.perfil);
            if (res) {
                this.rolUsuario = res.perfil!;
                if(this.rolUsuario == roleIntro){
                  console.log("entre en rol = rolintro");
                  logeado = true;
                  return true;
                }else{
                  logeado = false;
                  console.log("entre en rol != rolintro");
                  return  false;
                }
              }else{
                logeado = false;
                return false;
              }
            });
        }
      })
    );
    return logeado;

    // this.auth.stateUser().subscribe((res) => {
    //   if (res) {
    //     console.log(res.uid);
    //     // console.log('logueado',);
    //     this.firestoreService.getUserById(res.uid).subscribe((res) => {
    //       console.log('datos ->', res);
    //       if (res) {
    //         this.rolUsuario = res.perfil!;
    //       }
    //     });
    //     if(this.rolUsuario == roleIntro){
    //       logeado = true;
    //       console.log("entre en rol = rolintro");
    //     }else{
    //       logeado = false;
    //       console.log("entre en rol != rolintro");
    //     }
    //   } else {
    //     console.log('no loged');
    //     logeado = false;
    //   }
    // });
    // return logeado;

  }

  async getDatosUser(uid: string){
    this.firestoreService.getUserById(uid).subscribe((res) => {
      console.log('datos ->', res);
      if (res) {
        this.rolUsuario = res.perfil!; 
        return res.perfil
      }else{
        return null;
      }
    });
  }
}
