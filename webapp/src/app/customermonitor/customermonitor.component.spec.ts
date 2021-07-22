import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomermonitorComponent } from './customermonitor.component';

describe('CustomermonitorComponent', () => {
  let component: CustomermonitorComponent;
  let fixture: ComponentFixture<CustomermonitorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomermonitorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomermonitorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
