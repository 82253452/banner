import {Injectable,Component} from 'angular2/core';
import {Http, URLSearchParams, Headers, RequestOptions} from 'angular2/http';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';

@Injectable()
export class Common{
    constructor(private http : Http) {}

    post(url,data){
        let headers=new Headers({'Content-Type':'application/json'});
        /*let headers=new Headers({'Content-Type':'application/x-www-form-urlencoded',"charset":"UTF-8"});*/
        let options=new RequestOptions({headers:headers})
        let creds = JSON.stringify(data);
         return this.http.post(url, creds ,options).toPromise().then(

        );
    }
    get(url,data){
        let creds = JSON.stringify(data);
        return this.http.get(url, creds).toPromise().then(

        );
    }
}