import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-monitor-board',
  templateUrl: './monitor-board.component.html',
  styleUrls: ['./monitor-board.component.css']
})
export class MonitorBoardComponent implements OnInit {
  myType = 'ColumnChart';
  selected = 'option2';
  list = [];
  constructor() {}

  ngOnInit() {}
}
