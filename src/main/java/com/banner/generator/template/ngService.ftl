import {Injectable,Component} from 'angular2/core';
import {Common} from 'common/Common';
import {Http} from 'angular2/http';


@Injectable()
export class ${entityName}Service{

constructor( private common : Common,private http:Http){}

    List(){
         return this.common.post("/${entityName2}/list",{}).then(res=>res.json());
    }
    add(data){
         return this.common.post("/${entityName2}/add",data).then();
    }
    del(data){
         return this.common.post("/${entityName2}/del",data).then();
    }
    update(data){
          return this.common.post("/${entityName2}/update",data).then();
    }
    getById(data){
          return this.common.post("/${entityName2}/getById",data).then(res=>res.json());
    }

}


