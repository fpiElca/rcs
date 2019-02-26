import { Component, OnInit } from '@angular/core';
import { HaltestellenService } from '../haltestellen.service';
import { Haltestelle } from '../haltestelle';

@Component({
  selector: 'app-haltestellen-list',
  templateUrl: './haltestellen-list.component.html',
  styleUrls: ['./haltestellen-list.component.css']
})
export class HaltestellenListComponent implements OnInit {

  haltestellen: Haltestelle[];

  constructor(public haltestellenService: HaltestellenService) { }

  ngOnInit() {
    this.haltestellenService.getHaltestellen().subscribe(data => this.haltestellen = data);
  }

  toggleFavorite(haltestelle: Haltestelle): void {
    haltestelle.favorit = !haltestelle.favorit;
    // TODO: only send request to backend, following the toggleFavorite link on the haltestelle resource
  }
}
