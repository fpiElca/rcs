import {Component, OnInit} from '@angular/core';
import {Haltestelle} from '../haltestelle';
import {ActivatedRoute} from '@angular/router';
import {HaltestellenService} from '../haltestellen.service';

@Component({
  selector: 'app-haltestellen-detail',
  templateUrl: './haltestellen-detail.component.html',
  styleUrls: ['./haltestellen-detail.component.css']
})
export class HaltestellenDetailComponent implements OnInit {

  haltestelle: Haltestelle;

  constructor(private route: ActivatedRoute, private service: HaltestellenService) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.find(params['id'] as number).subscribe(res => this.haltestelle = res)
    });
  }

  previousState() {
    window.history.back();
  }
}
