import { BrowserModule } from "@angular/platform-browser";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { NgModule } from "@angular/core";

import { SharedModule } from "@app/shared";
import { CoreModule } from "@app/core";

import { SettingsModule } from "./settings";
import { StaticModule } from "./static";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HaltestelleListComponent } from "./haltestelle-list/haltestelle-list.component";
import { HaltestelleDetailComponent } from "./haltestelle-detail/haltestelle-detail.component";

@NgModule({
  imports: [
    // angular
    BrowserAnimationsModule,
    BrowserModule,

    // core & shared
    CoreModule,
    SharedModule,

    // features
    StaticModule,
    SettingsModule,

    // app
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    HaltestelleListComponent,
    HaltestelleDetailComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
