import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { GlobalService } from '../service/global.service';
import {HttpServiceService} from '../service/http-service.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-areadata',
  templateUrl: './areadata.component.html',
  styleUrls: ['./areadata.component.css']
})
export class AreadataComponent implements OnInit {

  provider: any;
  state: string;
  dist: string;
  locality: string;
  landArea: number;
  population: number;
  rawdata: any;

  constructor(private authService: AuthService, private globals: GlobalService, private http: HttpClient) { }

  ngOnInit() {
    this.provider = this.globals.provider;
    console.log(this.provider);
    this.http.post('http://localhost:8080/state/getPOState', this.globals.getProvider()
    ).subscribe(
      data => {
        console.log(data);
        this.rawdata = data;
      }, err => console.error(err)
    );
  }


}
