import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-wastagedashboard',
  templateUrl: './wastagedashboard.component.html',
  styleUrls: ['./wastagedashboard.component.css']
})
export class WastagedashboardComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  onBack() {
    this.router.navigate(['selectaction']);
  }
}
