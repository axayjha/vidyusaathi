import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SubsidiseddashboardComponent } from './subsidiseddashboard.component';

describe('SubsidiseddashboardComponent', () => {
  let component: SubsidiseddashboardComponent;
  let fixture: ComponentFixture<SubsidiseddashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SubsidiseddashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SubsidiseddashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
