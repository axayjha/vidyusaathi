import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BgcomponentComponent } from './bgcomponent.component';

describe('BgcomponentComponent', () => {
  let component: BgcomponentComponent;
  let fixture: ComponentFixture<BgcomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BgcomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BgcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
