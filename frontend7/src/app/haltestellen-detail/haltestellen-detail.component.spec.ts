import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HaltestellenDetailComponent } from './haltestellen-detail.component';

describe('HaltestellenDetailComponent', () => {
  let component: HaltestellenDetailComponent;
  let fixture: ComponentFixture<HaltestellenDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HaltestellenDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HaltestellenDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
