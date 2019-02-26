import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { HaltestellenComponent } from "./haltestellen.component";

describe("HaltestellenComponent", () => {
  let component: HaltestellenComponent;
  let fixture: ComponentFixture<HaltestellenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [HaltestellenComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HaltestellenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
