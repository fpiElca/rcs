import { Injectable } from '@angular/core';
import { Haltestelle } from './haltestelle';
import { Observable } from "rxjs";
import { from } from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class HaltestellenService {

  constructor() { }

  getHaltestellen(): Observable<Haltestelle[]> {
    // TODO: Return a collection resource
    return from([[{
      name: "Haltestelle 1",
      ort: "Bern",
      favorit: false
    }, {
      name: "Haltestelle 2",
      ort: "Bern",
      favorit: false
    }, {
      name: "Lorraine",
      ort: "Bern",
      favorit: true
    }, {
      name: "Bundesplatz",
      ort: "Bern",
      favorit: true
    }
  ]]);
  }
}
