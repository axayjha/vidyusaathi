import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WastagedashboardComponent } from './wastagedashboard.component';

describe('WastagedashboardComponent', () => {
  let component: WastagedashboardComponent;
  let fixture: ComponentFixture<WastagedashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WastagedashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WastagedashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
