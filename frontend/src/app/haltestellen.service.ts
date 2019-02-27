import {Injectable} from '@angular/core';
import {Haltestelle} from './haltestelle';
import {Observable} from "rxjs";
import {HttpClient} from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class HaltestellenService {

  public endpointUrl = '/api/';

  constructor(protected http: HttpClient) {
  }

  find(_self: string): Observable<Haltestelle> {
    return this.http
      .get<Haltestelle>(_self);
  }

  findAll(): Observable<Haltestelle[]> {
    return this.http
      .get<Haltestelle[]>(`${this.endpointUrl}haltestellen`);
  }

  suche(param: { query: any }): Observable<Haltestelle[]> {
    return this.http.get<Haltestelle[]>(`${this.endpointUrl}`);
  }
}
