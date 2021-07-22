import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-anomalydashboard',
  templateUrl: './anomalydashboard.component.html',
  styleUrls: ['./anomalydashboard.component.css']
})
export class AnomalydashboardComponent implements OnInit {
  constructor(private router: Router) {}
  myColumnNames = ['', 'LCL', 'CL', 'UCL', 'Consumption'];
  myData = [
    ['', 5, 15, 10, 7],
    ['', 5, 15, 10, 5],
    ['', 5, 15, 10, 16],
    ['', 5, 15, 10, 3],
    ['', 5, 15, 10, 7]
  ];
  ngOnInit() {}
  onBack() {
    console.log('back');
    this.router.navigate(['selectaction']);
  }
}
