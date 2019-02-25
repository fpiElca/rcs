import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { HaltestelleDetailComponent } from "./haltestelle-detail.component";

describe("HaltestelleDetailComponent", () => {
  let component: HaltestelleDetailComponent;
  let fixture: ComponentFixture<HaltestelleDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [HaltestelleDetailComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HaltestelleDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
