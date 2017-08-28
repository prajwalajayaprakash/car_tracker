import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http} from "@angular/http";

@Injectable()
export class AlertService {

  constructor(private http: Http) { }
  getAlertsByVin(alertsVin): Observable<any> {
    return this.http.get(`http://localhost:8080/alerts/${alertsVin}`, alertsVin)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
  getAlerts(): Observable<any[]> {
    return this.http.get("http://localhost:8080/alerts")
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }

}
