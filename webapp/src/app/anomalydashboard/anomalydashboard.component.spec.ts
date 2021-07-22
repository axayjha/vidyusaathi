import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnomalydashboardComponent } from './anomalydashboard.component';

describe('AnomalydashboardComponent', () => {
  let component: AnomalydashboardComponent;
  let fixture: ComponentFixture<AnomalydashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnomalydashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnomalydashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
