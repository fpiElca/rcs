import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {HaltestellenComponent} from '@app/haltestelle-list/haltestellen.component';
import {HaltestelleDetailComponent} from '@app/haltestelle-detail/haltestelle-detail.component';

const routes: Routes = [
	{
		path: "",
		redirectTo: "haltestellen",
		pathMatch: "full"
	},
	{
		path: "haltestellen",
		component: HaltestellenComponent,
	},
	{
		path: "haltestelle/:id",
		component: HaltestelleDetailComponent,
	},
];

@NgModule({
	// useHash supports github.io demo page, remove in your app
	imports: [
		RouterModule.forRoot(routes, {
			useHash: true,
			scrollPositionRestoration: "enabled"
		})
	],
	exports: [RouterModule]
})
export class AppRoutingModule {
}
