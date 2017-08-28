import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ReadingsService} from "../readings-service/readings.service";
import {log} from "util";


@Component({
  selector: 'app-readings-detail',
  templateUrl: './readings-detail.component.html',
  styleUrls: ['./readings-detail.component.css']
})
export class ReadingsDetailComponent implements OnInit {
  readings;
  latitude = 12.9716;
  longitude = 77.5946;
  speedTrack = [];
  fuelVolume = [];
  engineRPM = [];
  time = [];

  constructor(private route: ActivatedRoute, private readingsService: ReadingsService) {}
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.readingsService.getReadingsByVin(params.id)
        .subscribe(readings => this.readings = readings);
    });
  }

  showLocation(latitude, longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  speedChart(speed) {
    this.speedTrack.push(speed);
  }
  fuelVolumechart(fuel) {
    this.fuelVolume.push(fuel);
  }

  engineRPMChart(rpm) {
    this.engineRPM.push(rpm);
  }

  timeLabel(currentTime) {
    this.time.push(currentTime);
  }

  public graphs() {
    this.speedGraph();
    this.fuelVolumeGraph();
    this.engineRPMGraph();
  }

  //CHART FOR SPEED
  public lineChartData: Array<any> = [
    {data: [0,0,0,0,0], label: 'SPEED(Miles/Hr)'}
  ];

  //CHART FOR FUEL VOLUME
  public lineChartData1: Array<any> = [
    {data: [0,0,0,0,0], label: 'FUEL VOLUME'}
  ];

  //CHART FOR ENGINE RPM
  public lineChartData2: Array<any> = [
    {data: [0,0,0,0,0], label: 'ENGINE RPM'}
  ];

  //COMMON CHART PARAMETERS
  public lineChartLabels:Array<any> = new Array(5);

  public lineChartOptions:any = {
    responsive: true
  };
  public lineChartColors:Array<any> = [
    { // grey
      backgroundColor: 'rgba(200,159,177,0.2)',
      borderColor: 'rgba(148,159,177,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    }
   ];
  public lineChartLegend:boolean = true;
  public lineChartType:string = 'line';

  //SPEED GRAPH FUNCTIONS
  public speedGraph():void {
    this.labels();
    let _lineChartData:Array<any> = new Array(this.lineChartData.length);
    for (let i = 0; i < this.lineChartData.length; i++) {
      _lineChartData[i] = {data: new Array(this.lineChartData[i].data.length), label: this.lineChartData[i].label};
      for (let j = 0; j < this.lineChartData[i].data.length; j++) {
        _lineChartData[i].data[j] = this.speedTrack[j];
      }
    }
    this.lineChartData = _lineChartData;
}

  //FUEL VOLUME GRAPH FUNCTIONS
  public fuelVolumeGraph():void {
    this.labels();
    let _lineChartData1:Array<any> = new Array(this.lineChartData1.length);
    for (let i = 0; i < this.lineChartData1.length; i++) {
      _lineChartData1[i] = {data: new Array(this.lineChartData1[i].data.length), label: this.lineChartData1[i].label};
      for (let j = 0; j < this.lineChartData1[i].data.length; j++) {
        _lineChartData1[i].data[j] = this.fuelVolume[j];
      }
    }
    this.lineChartData1 = _lineChartData1;
  }

  //ENGINE RPM GRAPH FUNCTIONS
  public engineRPMGraph():void {
    this.labels();
    let _lineChartData2:Array<any> = new Array(this.lineChartData2.length);
    for (let i = 0; i < this.lineChartData1.length; i++) {
      _lineChartData2[i] = {data: new Array(this.lineChartData2[i].data.length), label: this.lineChartData2[i].label};
      for (let j = 0; j < this.lineChartData2[i].data.length; j++) {
        _lineChartData2[i].data[j] = this.engineRPM[j];
      }
    }
    this.lineChartData2 = _lineChartData2;
  }

  //LABEL FUNCTION
  public labels() {
    for (let i = 0; i < this.lineChartLabels.length; i++) {
      this.lineChartLabels[i] = this.time[i];
    }
  }

    //EVENTS
  public chartClicked(e: any): void {
    console.log(e);
  }

  public chartHovered(e:any):void {
    console.log(e);
  }
}

