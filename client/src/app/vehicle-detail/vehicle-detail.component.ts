import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {VehicleService} from "../vehicle-service/vehicle.service";

@Component({
  selector: 'app-vehicle-detail',
  templateUrl: './vehicle-detail.component.html',
  styleUrls: ['./vehicle-detail.component.css']
})
export class VehicleDetailComponent implements OnInit {
  vehicle;
  constructor(private route: ActivatedRoute, private vehicleService: VehicleService) {}
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.vehicleService.getVehicleById(params.id)
        .subscribe(vehicle => this.vehicle = vehicle);
    });
  }


}
