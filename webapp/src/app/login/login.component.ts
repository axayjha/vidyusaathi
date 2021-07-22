import { Component, OnInit } from '@angular/core';
import { RegisterUser } from '../registerUser';
import { FormControl, Validators, FormGroup } from '@angular/forms';
import { AuthService } from '../auth/auth.service';
import { GlobalService } from '../service/global.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  registerUser: RegisterUser = new RegisterUser();
  loginUser: FormGroup;
  authCode: string;
  showSuccessMessage = false;
  constructor(private userService: AuthService, private globals: GlobalService) { }

  ngOnInit() {
    this.loginUser = new FormGroup({
      email: new FormControl(this.registerUser.email, [
        Validators.required,
        Validators.email
      ]),
      password: new FormControl(this.registerUser.password, [
        Validators.required
      ])
    });
    this.authCode = this.globals.authorisationCode;
    this.showSuccessMessage = this.globals.showLogin;
  }

  onLogin() {
    console.log('Calling');
    this.registerUser.email = this.email.value;
    this.registerUser.password = this.password.value;
    this.userService.login(this.registerUser);
  }
  get email() { return this.loginUser.get('email'); }
  get password() { return this.loginUser.get('password'); }

}
