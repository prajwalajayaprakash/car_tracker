import {Component, OnInit} from '@angular/core';
import {AlertService} from "../alert-service/alert.service";

@Component({
  selector: 'app-all-alerts',
  templateUrl: './all-alerts.component.html',
  styleUrls: ['./all-alerts.component.css']
})
export class AllAlertsComponent implements OnInit {
 alertsObservable;
  constructor(private alertService: AlertService) {}
  ngOnInit(): void {
    this.alertsObservable = this.alertService.getAlerts();
  }
}
