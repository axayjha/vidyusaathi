import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RootdashboardComponent } from './rootdashboard.component';

describe('RootdashboardComponent', () => {
  let component: RootdashboardComponent;
  let fixture: ComponentFixture<RootdashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RootdashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RootdashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
