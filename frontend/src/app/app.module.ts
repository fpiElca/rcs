import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HaltestellenListComponent } from './haltestellen-list/haltestellen-list.component';
import { HaltestellenDetailComponent } from './haltestellen-detail/haltestellen-detail.component';

import {MatListModule, MatIconModule} from '@angular/material';

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
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
