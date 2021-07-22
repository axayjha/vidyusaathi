import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormGroup} from '@angular/forms';
import {equalityChecker} from './matchValidator';
import {RegisterUser} from '../registerUser';
import { UserService } from '../user.service';
import { GlobalService } from '../service/global.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerUser: RegisterUser = new RegisterUser();
  favoriteSeason: string;
  seasons: string[] = ['Winter', 'Spring', 'Summer', 'Autumn'];
  regForm: FormGroup;
  retypePassword: string;
  echoPassword: string;
  processing = false;
  pwdMatching(): boolean {
    return this.regForm.value.rePassword === this.regForm.value.password;
  }
  constructor(private userService: UserService, private globals: GlobalService, private router: Router) {}

  ngOnInit() {
    this.regForm = new FormGroup(
      {
        email: new FormControl(this.registerUser.email, [
          Validators.required,
          Validators.email
        ]),
        password: new FormControl(this.registerUser.password, [
          Validators.required
        ]),
        rePassword: new FormControl(this.retypePassword, [
          Validators.required
        ]),
        authCode: new FormControl(this.registerUser.authorisationCode, [
          Validators.required
        ]),
        type: new FormControl(this.registerUser.type, [Validators.required])
      },
      { validators: equalityChecker }
    );
  }
  onSubmit() {
    this.registerUser.email = this.email.value;
    this.registerUser.password = this.password.value;
    this.registerUser.authorisationCode = this.authCode.value;
    this.registerUser.type = this.type.value;
    this.processing = true;
    this.userService.addUser(this.registerUser).subscribe(
      data => {
        console.log(data);
        this.globals.showLogin = true;
        this.processing = false;
        this.router.navigate(['login']);
      },
      error => console.log(error))
  }
  get email() { return this.regForm.get('email'); }
  get password() { return this.regForm.get('password'); }
  get rePassword() { return this.regForm.get('rePassword'); }
  get authCode() { return this.regForm.get('authCode'); }
  get type() { return this.regForm.get('type'); }
}
