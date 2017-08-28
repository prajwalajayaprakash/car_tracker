import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http} from "@angular/http";

@Injectable()
export class ReadingsService {

  constructor(private http: Http) { }
  getReadingsByVin(readingsVin): Observable<any> {
    return this.http.get(`http://localhost:8080/readings/${readingsVin}`, readingsVin)
      .map(response => response.json())
      .catch(error => Observable.throw(error.statusText));
  }
}
