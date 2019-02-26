import {BrowserModule} from '@angular/platform-browser';
import {Injectable, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HaltestellenListComponent} from './haltestellen-list/haltestellen-list.component';
import {HaltestellenDetailComponent} from './haltestellen-detail/haltestellen-detail.component';

import {MatIconModule, MatListModule} from '@angular/material';
import {HttpClientModule} from '@angular/common/http';
import {ActivatedRouteSnapshot, Resolve, RouterModule, RouterStateSnapshot, Routes} from '@angular/router';
import {Haltestelle} from './haltestelle';
import {Observable, of} from 'rxjs';
import {HaltestellenService} from './haltestellen.service';

@Injectable({ providedIn: 'root' })
export class HaltestellenResolver implements Resolve<Haltestelle> {
  constructor(private service: HaltestellenService) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Haltestelle> {
    const id = route.params['id'] ? route.params['id'] : null;
    if (id) {
      return this.service.find(id);
    }
    return of(new Haltestelle());
  }
}

const routes: Routes = [
  {
    path: '',
    redirectTo: 'haltestellen',
    pathMatch: 'full'
  },
  { path: "", component: HaltestellenListComponent},
  {
    path: ':id',
    component: HaltestellenDetailComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    HaltestellenListComponent,
    HaltestellenDetailComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatListModule,
    MatIconModule,
    HttpClientModule,
    RouterModule.forRoot(
      routes
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})


export class AppModule { }
