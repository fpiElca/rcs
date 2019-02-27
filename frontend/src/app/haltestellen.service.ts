import {Injectable} from '@angular/core';
import {Haltestelle} from './haltestelle';
import {Observable} from "rxjs";
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class HaltestellenService {

  endpointUrl = '/api/';
  haltenstellenEndpointUrl = '/api/haltestellen/';

  constructor(protected http: HttpClient) {
  }

  find(_self: string): Observable<Haltestelle> {
    return this.http
      .get<Haltestelle>(_self);
  }

  findAll(): Observable<Haltestelle[]> {
    return this.http
      .get<Haltestelle[]>(`${this.haltenstellenEndpointUrl}`);
  }

  suche(param: { query: string }): Observable<Haltestelle[]> {
    return this.http.get<Haltestelle[]>(`${this.haltenstellenEndpointUrl}search/findByNameContainingIgnoreCase?name=${param.query}`);
  }
}
