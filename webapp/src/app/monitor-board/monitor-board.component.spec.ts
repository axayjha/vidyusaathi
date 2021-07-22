import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MonitorBoardComponent } from './monitor-board.component';

describe('MonitorBoardComponent', () => {
  let component: MonitorBoardComponent;
  let fixture: ComponentFixture<MonitorBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MonitorBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MonitorBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
