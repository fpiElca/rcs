import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HaltestellenListComponent } from './haltestellen-list.component';

describe('HaltestellenListComponent', () => {
  let component: HaltestellenListComponent;
  let fixture: ComponentFixture<HaltestellenListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HaltestellenListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HaltestellenListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
