import {Component} from 'angular2/core';
import {Http} from 'angular2/http';
import {Router} from 'angular2/router';
import 'rxjs/Rx';

@Component({
  selector: 'home',
  templateUrl: 'app/components/home/home.html',
  styleUrls: ['app/components/home/home.css'],
  providers: [],
  directives: [],
  pipes: []
})
export class Home {
  public activityResults;
  constructor(private http : Http, private router : Router) {
      this.loadJSON();
  }
  loadJSON(){
      this.http.get("../../../ListOfAAResponse.json")
      .map(res => res.json())
      .subscribe( (res:any) => {

          if(res.activityAlert && res.activityAlert.length){
            res.activityAlert.forEach((aa)=>{
              aa.status = aa["@status"];
              delete aa["@status"];
            });
            this.activityResults = res.activityAlert;
          }
      });
  }

  handleClick(index){
    this.router.parent.navigate(["Details", {index: index}]);
  }
}
