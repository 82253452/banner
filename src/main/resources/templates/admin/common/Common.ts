import {Injectable,Component} from 'angular2/core';
import {Http, URLSearchParams} from 'angular2/http';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';

@Injectable()
export class Common{
    constructor(private http : Http) {}

    post(url,data){
        let creds = JSON.stringify(data);
         return this.http.post(url, creds).toPromise().then(

        );
    }
    get(url,data){
        let creds = JSON.stringify(data);
        return this.http.get(url, creds).toPromise().then(

        );
    }
}