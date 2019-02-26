import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HaltestellenListComponent} from './haltestellen-list/haltestellen-list.component';
import {HaltestellenDetailComponent} from './haltestellen-detail/haltestellen-detail.component';

import {MatCardModule, MatIconModule, MatListModule} from '@angular/material';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {
    path: 'detail/:self',
    component: HaltestellenDetailComponent
  },
  {
    path: 'haltestellen',
    component: HaltestellenListComponent
  },
  { path: '',
    redirectTo: '/haltestellen',
    pathMatch: 'full'
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
    MatCardModule,
    HttpClientModule,
    RouterModule.forRoot(
      routes,
      { enableTracing: true }
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})


export class AppModule {
}
