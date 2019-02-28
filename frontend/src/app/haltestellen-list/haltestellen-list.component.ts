import {Component, OnInit, ViewChild} from '@angular/core';

import {FormBuilder, FormGroup} from '@angular/forms';
import {MatPaginator, MatSort, MatTableDataSource, PageEvent} from '@angular/material';

import {debounceTime, distinctUntilChanged, finalize, switchMap, tap} from 'rxjs/operators';

import {HaltestellenService} from '../haltestellen.service';
import {Haltestelle} from '../haltestelle';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-haltestellen-list',
  templateUrl: './haltestellen-list.component.html',
  styleUrls: ['./haltestellen-list.component.css']
})
export class HaltestellenListComponent implements OnInit {

  displayedColumns: string[] = ['favorite', 'name', 'ort'];
  dataSource: MatTableDataSource<Haltestelle>;

  @ViewChild(MatSort) sort: MatSort;

  // MatPaginator Inputs
  length = 0;
  pageIndex = 0;
  pageSize = 0;
  pageSizeOptions: number[] = [5, 20, 50, 100];
  data: Observable<Haltestelle[]>;
  previousPageIndex: number = 0;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  gefundeneHaltestellen: Haltestelle[] = [];
  suchFormulare: FormGroup;
  wirdGeladen = false;

  constructor(private haltestellenService: HaltestellenService,
              private formBuilder: FormBuilder,
              private router: Router) {
  }

  private initDatasource(data: any) {
    this.data = data;
    this.dataSource = new MatTableDataSource<Haltestelle>(data['_embedded']['rcs:haltestellen']);
    this.length = data['page']['totalElements'];
    this.pageSize = data['page']['size'];

    this.wirdGeladen = true
  }

  ngOnInit() {

    this.haltestellenService.findAll({size:this.pageSize}).subscribe(data => {
      this.initDatasource(data);
      this.dataSource.paginator = this.paginator;
    });

    this.suchFormulare = this.formBuilder.group({
      gesuchteHaltestelle: null
    })

    this.suchFormulare
      .get('gesuchteHaltestelle')
      .valueChanges
      .pipe(
        debounceTime(600),
        distinctUntilChanged(),
        tap(() => this.wirdGeladen = true),
        switchMap(value => this.haltestellenService.findByName({query: value})
          .pipe(
            finalize(() => this.wirdGeladen = false),
          )
        )
      )
      .subscribe(data => this.initDatasource(data));
  }

  toggleFavorite(haltestelle: Haltestelle): void {
    this.suchFormulare.get('gesuchteHaltestelle');
    haltestelle.favorite = !haltestelle.favorite;
    // TODO: only send request to backend, following the toggleFavorite link on the haltestelle resource
  }

  displayFn(haltestellen: Haltestelle) {
    if (haltestellen) {
      return haltestellen.name;
    }
  }

  onRowClicked(haltestelle: Haltestelle) {
    this.router.navigate(['detail/', haltestelle._links.self.href]);
  }

  handlePagination(event?: PageEvent) {
    console.log(event);
    let action = {
      next: (this.pageIndex + 1) === event.pageIndex ,
      previous: this.pageIndex === (event.pageIndex + 1),
      first: event.pageIndex === 0 && this.pageSize === event.pageSize,
      last: event.pageIndex === ~~(event.length / event.pageSize),
      pageSizeChanged: this.pageSize !== event.pageSize
    }
    this.pageIndex = event.pageIndex;
    this.length = event.length;
    this.pageSize = event.pageSize;
    let loadData = this.doPagination(action);
    loadData.subscribe(data => {
      this.initDatasource(data);
    });
  }

  private doPagination(action: { next: boolean, previous: boolean, first: boolean, last: boolean, pageSizeChanged: boolean }): Observable<Haltestelle[]> {
    if (action.next) {
      return this.haltestellenService.find(this.data['_links']['next']['href']);
    } else if (action.previous) {
      return this.haltestellenService.find(this.data['_links']['prev']['href']);
    } else if (action.first) {
      return this.haltestellenService.find(this.data['_links']['first']['href']);
    } else if (action.last) {
      return this.haltestellenService.find(this.data['_links']['last']['href']);
    } else if (action.pageSizeChanged) {
      return this.haltestellenService.findAll({size:this.pageSize});
    }
  }
}
