import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AreadataComponent } from './areadata.component';

describe('AreadataComponent', () => {
  let component: AreadataComponent;
  let fixture: ComponentFixture<AreadataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AreadataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AreadataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
