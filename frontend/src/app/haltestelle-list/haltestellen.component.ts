import {ChangeDetectionStrategy, Component, OnInit} from "@angular/core";
import {Haltestelle} from '@app/haltestelle-detail/haltestelle-model';
import {HaltestellenService} from '@app/haltestelle-list/haltestellen.service';

@Component({
	selector: "anms-haltestellen",
	templateUrl: "./haltestellen.component.html",
	styleUrls: ["./haltestellen.component.css"],
	changeDetection: ChangeDetectionStrategy.OnPush
})
export class HaltestellenComponent implements OnInit {

	stops: Haltestelle[];

	constructor(protected service: HaltestellenService) {
	}

	ngOnInit() {
		this.service.getAll().subscribe((response: Haltestelle[]) => {
				this.stops = response;
			},
			(error: any) => {
				console.error(error);
			}
		)
	}


}
