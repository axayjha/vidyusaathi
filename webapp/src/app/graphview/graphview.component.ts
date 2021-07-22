import { Component, OnInit, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GlobalService } from '../service/global.service';




@Component({
  selector: 'app-graphview',
  templateUrl: './graphview.component.html',
  styleUrls: ['./graphview.component.css']
})

export class GraphviewComponent implements OnInit {
  mode: number;
  provider: any;
  feedbacklist: any;
  myData = [
    ['2 AM', 2],
    ['8 AM', 5],
    ['2 PM', 7],
    ['8 PM', 2]
  ];
  constructor(private http: HttpClient, private globals: GlobalService) { }

  ngOnInit() {
    this.mode = 1;
    this.provider = this.globals.provider;
    console.log(this.globals.provider);
  }
  modeChange(value: string) {
    console.log(value);
    if (value === '1') {
      this.myData = [
        ['2 AM', 7],
        ['8 AM', 5],
        ['2 PM', 7],
        ['8 PM', 2]
      ];
    } else if (value === '2') {
      this.myData = [
        ['Jan', 23],
        ['Apr', 57],
        ['Aug', 74],
        ['Dec', 21]
      ];
    } else {
      this.myData = [
        ['1980', 23],
        ['1990', 57],
        ['2000', 74],
        ['2010', 21]
      ];
    }
  }
  getYear(): void {

  }
}
