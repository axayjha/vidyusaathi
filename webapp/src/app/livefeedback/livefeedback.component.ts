import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GlobalService } from '../service/global.service';

@Component({
  selector: 'app-livefeedback',
  templateUrl: './livefeedback.component.html',
  styleUrls: ['./livefeedback.component.css']
})
export class LivefeedbackComponent implements OnInit {
  provider: any;
  feedbacklist: any;
  constructor(private http: HttpClient, private globals: GlobalService) {}

  ngOnInit() {
    this.provider = this.globals.provider;
    console.log(this.globals.provider);
    this.getbyProvider();
  }
  getbyProvider(): void {
    setInterval(() => {
      this.http
        .post('http://localhost:8080/feedback/getByLocality', this.provider)
        .subscribe(
          data => {
            this.feedbacklist = data;
          },
          err => console.log(err)
        );
    }, 1000);
  }
  getDateString(value: number) : string{
    return new Date(value).toLocaleDateString() + ' ' + new Date(value).toLocaleTimeString();
  }
}
