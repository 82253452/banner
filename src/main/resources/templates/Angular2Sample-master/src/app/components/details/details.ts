/**
 * Created by MTA on 4/8/2016.
 */


import {Component, OnInit} from 'angular2/core';
import {RouteParams} from 'angular2/router';
import {Http} from 'angular2/http';
@Component({
  selector: 'details-viewer',
  templateUrl: 'app/components/details/details.html'
})

export class Details implements OnInit{

  private index;
  public activityAlert;
  constructor(private http : Http, private routeParams : RouteParams){}
  ngOnInit(){
    this.index = this.routeParams.get("index");
    this.loadJSON();
  }

  loadJSON(){
    this.http.get("../../../ListOfAAResponse.json")
      .map(res => res.json())
      .subscribe( (res:any) => {
        if(res.activityAlert && res.activityAlert.length){
          this.activityAlert = JSON.stringify(res.activityAlert[this.index]);
        }
      });
  }


}
