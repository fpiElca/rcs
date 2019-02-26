import {Injectable} from '@angular/core';
import {Haltestelle} from './haltestelle';
import {from, Observable} from "rxjs";
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class HaltestellenService {

  public endpointUrl = '/api/';

  constructor(protected http: HttpClient) {
  }

  // getHaltestellen(): Observable<Haltestelle[]> {
  //   // TODO: Return a collection resource
  //   return from([[{
  //     id: 1,
  //     name: "Haltestelle 1",
  //     ort: "Bern",
  //     favorit: false,
  //     hoehe: null,
  //     gemeinde: "",
  //     transportunternehmung: "",
  //     koordOst: null,
  //     koordNord: null
  //   }, {
  //     id: 2,
  //     name: "Haltestelle 2",
  //     ort: "Bern",
  //     favorit: false,
  //     hoehe: null,
  //     gemeinde: "",
  //     transportunternehmung: "",
  //     koordOst: null,
  //     koordNord: null
  //   }, {
  //     id: 3,
  //     name: "Lorraine",
  //     ort: "Bern",
  //     favorit: true,
  //     hoehe: null,
  //     gemeinde: "",
  //     transportunternehmung: "",
  //     koordOst: null,
  //     koordNord: null
  //   }, {
  //     id: 4,
  //     name: "Bundesplatz",
  //     ort: "Bern",
  //     favorit: true,
  //     hoehe: null,
  //     gemeinde: "",
  //     transportunternehmung: "",
  //     koordOst: null,
  //     koordNord: null
  //   }
  //   ]]);
  // }

  find(_self: string): Observable<Haltestelle> {
    return this.http
      .get<Haltestelle>(_self);
  }

  findAll(): Observable<Haltestelle[]> {
    return this.http
      .get<Haltestelle[]>(`${this.endpointUrl}haltestellen`);
  }
}
