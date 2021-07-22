import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegisterUser } from './registerUser';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) {}

  addUser(registerUser: RegisterUser): Observable<RegisterUser> {
    return this.http.post<RegisterUser>(
      'http://localhost:8080/dataviewer/register',
      registerUser
    );
  }
}
