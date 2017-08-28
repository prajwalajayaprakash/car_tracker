import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AlertService} from "../alert-service/alert.service";

@Component({
  selector: 'app-alert-details',
  templateUrl: './alert-details.component.html',
  styleUrls: ['./alert-details.component.css']
})
export class AlertDetailsComponent implements OnInit{
  alerts;
  count = 0;
  constructor(private route: ActivatedRoute, private alertService: AlertService) {}
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.alertService.getAlertsByVin(params.id)
        .subscribe(alerts => this.alerts = alerts);
    });
  }
  countAlerts() {
  this.count += 1;
  }
}
