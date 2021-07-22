import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router) { }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ):
    | Observable<boolean | UrlTree>
    | Promise<boolean | UrlTree>
    | boolean
    | UrlTree {
    return true;
  }
  checkLogin(url: string): boolean {
    if (this.authService.isLoggedIn) {
      console.log(this.authService.isLoggedIn);
      return true;}
    console.log(this.authService.isLoggedIn);
    this.authService.redirectUrl = url;
    this.router.navigate(['/login']);
    return false;
  }

}
