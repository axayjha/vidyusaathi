import { Component, OnInit } from '@angular/core';
import { Customer } from './customer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-subsidiseddashboard',
  templateUrl: './subsidiseddashboard.component.html',
  styleUrls: ['./subsidiseddashboard.component.css']
})
export class SubsidiseddashboardComponent implements OnInit {
  customers = [
    new Customer('User 1', 'Normal', 'Book1' ),
    new Customer('User 2', 'Normal', 'Book2'),
    new Customer('User 3', 'Alert', 'Book3'),
    new Customer('User 4', 'Normal', 'Book4'),
    new Customer('User 5', 'Normal', 'Book5')
  ];
  constructor(private router: Router) { }

  ngOnInit() {
  }
  onBack() {
    console.log('back');
    this.router.navigate(['selectaction']);
  }

}
