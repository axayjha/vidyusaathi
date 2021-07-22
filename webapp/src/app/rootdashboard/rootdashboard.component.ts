import { Component, OnInit } from '@angular/core';
import { GlobalService } from '../service/global.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-rootdashboard',
  templateUrl: './rootdashboard.component.html',
  styleUrls: ['./rootdashboard.component.css']
})
export class RootdashboardComponent implements OnInit {

  provider: any;
  constructor(private globals: GlobalService, private router: Router) { }

  ngOnInit() {
    console.log(this.globals.getProvider());
    this.provider = this.globals.provider;
  }
  openInterruption(): void {
     this.globals.provider = this.provider;
     this.router.navigate(['interruption']);
  }
  openSubsidy(): void {
    this.globals.provider = this.provider;
    this.router.navigate(['subsidised']);
  }
  openAnomaly() : void {
    this.globals.provider = this.provider;
    this.router.navigate(['anomaly']);
  }
  openWastage(): void {
    this.globals.provider = this.provider;
    this.router.navigate(['wastage']);
  }
  onBack() {
    this.router.navigate(['']);
  }
}
