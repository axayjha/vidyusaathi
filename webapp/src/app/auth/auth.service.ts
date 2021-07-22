import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegisterUser } from '../registerUser';
import { Router } from '@angular/router';
import { GlobalService } from '../service/global.service';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isLoggedIn = false;
  redirectUrl = 'dashboard';
  authorisationCode: string;
  provider: any;
  constructor(private http: HttpClient, private router: Router, private globals: GlobalService) {}

  login(registerUser: RegisterUser) {
    this.http
      .post<RegisterUser>(
        'http://localhost:8080/dataviewer/login',
        registerUser
      )
      .subscribe(
        data => {
          this.isLoggedIn = true;
          console.log(data);
          this.globals.provider = data.provider;
          this.router.navigate(['selectaction']);
        },
        err => {
          console.log(err);
        }
      );
  }
  logout(): void {
    this.isLoggedIn = false;
  }
}
