import {Component, OnInit, ViewChild} from '@angular/core';

import {FormBuilder, FormGroup} from '@angular/forms';
import {MatPaginator, MatTableDataSource} from '@angular/material';

import {debounceTime, finalize, switchMap, tap} from 'rxjs/operators';

import {HaltestellenService} from '../haltestellen.service';
import {Haltestelle} from '../haltestelle';

@Component({
  selector: 'app-haltestellen-list',
  templateUrl: './haltestellen-list.component.html',
  styleUrls: ['./haltestellen-list.component.css']
})
export class HaltestellenListComponent implements OnInit {

  displayedColumns: string[] = ['favorite', 'name', 'ort'];
  dataSource: MatTableDataSource<Haltestelle>;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  gefundeneHaltestellen: Haltestelle[] = [];
  suchFormulare: FormGroup;
  wirdGeladen = false;

  constructor(private haltestellenService: HaltestellenService,
              private formBuilder: FormBuilder) {
  }

  private initDatasource(haltestellen: Haltestelle[]){
    this.dataSource = new MatTableDataSource<Haltestelle>(haltestellen);
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit() {

    this.haltestellenService.findAll().subscribe(data => {
      this.initDatasource(data['_embedded'].haltestellen);
    });

    this.suchFormulare = this.formBuilder.group({
      gesuchteHaltestelle: null
    })

    this.suchFormulare
      .get('gesuchteHaltestelle')
      .valueChanges
      .pipe(
        debounceTime(300),
        tap(() => this.wirdGeladen = true),
        switchMap(value => this.haltestellenService.findAll()
          .pipe(
            finalize(() => this.wirdGeladen = false),
          )
        )
      )
      .subscribe(data => {
        this.gefundeneHaltestellen = data['_embedded'].haltestellen
        this.initDatasource(this.gefundeneHaltestellen);
      });
  }

  toggleFavorite(haltestelle: Haltestelle): void {
    haltestelle.favorite = !haltestelle.favorite;
    // TODO: only send request to backend, following the toggleFavorite link on the haltestelle resource
  }

  displayFn(haltestellen: Haltestelle) {
    if (haltestellen) { return haltestellen.name; }
  }
}
