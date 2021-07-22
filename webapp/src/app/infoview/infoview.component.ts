import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-infoview',
  templateUrl: './infoview.component.html',
  styleUrls: ['./infoview.component.css']
})
export class InfoviewComponent implements OnInit {
  area = 'Sample Area';
  constructor() {}
  av1 = 1;
  av2 = 1;
  nav1 = 20;
  sav1 = 7;
  nav2 = 15;
  sav2 = 7;
  med1 = 2;
  med2 = 2;
  dav1 = 1;
  dav2 = 3;

  ngOnInit() {}
  onChange1(value: string) {
    if (value === '1') {
      this.av1 = 1;
      this.nav1 = 1;
      this.sav1 = 7;
      this.dav1 = 1;
    }
  }

  onChnage2(value: string) {}
}
