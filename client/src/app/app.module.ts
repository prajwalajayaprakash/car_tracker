import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import {RouterModule, Routes} from "@angular/router";
import {HttpModule} from "@angular/http";
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { VehicleDetailComponent } from './vehicle-detail/vehicle-detail.component';
import {VehicleService} from "./vehicle-service/vehicle.service";
import { ReadingsDetailComponent } from './readings-detail/readings-detail.component';
import {ReadingsService} from "./readings-service/readings.service";
import { AlertDetailsComponent } from './alert-details/alert-details.component';
import {AlertService} from "./alert-service/alert.service";
import { AllAlertsComponent } from './all-alerts/all-alerts.component';
import { AgmCoreModule } from '@agm/core';
import { ChartsModule } from 'ng2-charts';


const appRoutes: Routes = [
    {path: 'vehicles', component: VehicleListComponent},
    {path: 'vehicles/:id', component: VehicleDetailComponent},
    {path: 'readings/:id', component: ReadingsDetailComponent},
    {path: 'readings/maps/:id/:id2', component: ReadingsDetailComponent},
    {path: 'alerts', component: AllAlertsComponent},
    {path: 'alerts/:id', component: AlertDetailsComponent},
    {path: 'homepage', component: LandingPageComponent},
    {path: '', redirectTo: '/homepage', pathMatch: 'full'}
];
@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    VehicleListComponent,
    VehicleDetailComponent,
    ReadingsDetailComponent,
    AlertDetailsComponent,
    AllAlertsComponent,
    ],
  imports: [
    BrowserModule,
    HttpModule,
    ChartsModule,
    RouterModule.forRoot(appRoutes),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAusOm-8nXLStw_eeWSdEFjPbooQ55472c'
    })
  ],
  providers: [VehicleService,
              ReadingsService,
              AlertService],
  bootstrap: [AppComponent]
})
export class AppModule { }
