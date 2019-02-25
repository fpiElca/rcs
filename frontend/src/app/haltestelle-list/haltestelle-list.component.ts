import { Component, OnInit, ChangeDetectionStrategy } from "@angular/core";

@Component({
  selector: "anms-haltestelle-list",
  templateUrl: "./haltestelle-list.component.html",
  styleUrls: ["./haltestelle-list.component.css"],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class HaltestelleListComponent implements OnInit {
  constructor() {}

  ngOnInit() {}
}
