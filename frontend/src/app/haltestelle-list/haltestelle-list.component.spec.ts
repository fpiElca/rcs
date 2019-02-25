import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { HaltestelleListComponent } from "./haltestelle-list.component";

describe("HaltestelleListComponent", () => {
  let component: HaltestelleListComponent;
  let fixture: ComponentFixture<HaltestelleListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [HaltestelleListComponent]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HaltestelleListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
