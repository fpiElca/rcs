import {Injectable} from '@angular/core';
import {Haltestelle} from '@app/haltestelle-detail/haltestelle-model';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
	providedIn: 'root'
})
export class HaltestellenService {

	haltestellen: Haltestelle[];


	constructor(protected httpClient: HttpClient) {
	}

	getAll(): Observable<Haltestelle[]> {
		return this.httpClient.get<Haltestelle[]>('http://localhost:8080/haltenstellen', {headers: this.getHttpHeaders()});
	}

	getDetails(id: number): Observable<Haltestelle[]> {
		return this.httpClient.get<Haltestelle[]>('http://localhost:8080/haltenstellen/' + id, {headers: this.getHttpHeaders()});
	}

	protected getHttpHeaders(): HttpHeaders {
		return new HttpHeaders()
			.set('Content-Type', 'application/json')
			.set('Accept', 'application/json');
	}


}
