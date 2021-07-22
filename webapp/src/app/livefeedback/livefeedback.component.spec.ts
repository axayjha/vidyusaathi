import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LivefeedbackComponent } from './livefeedback.component';

describe('LivefeedbackComponent', () => {
  let component: LivefeedbackComponent;
  let fixture: ComponentFixture<LivefeedbackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LivefeedbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LivefeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
