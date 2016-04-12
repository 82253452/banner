import {Injectable,Component} from 'angular2/core';
import {Common} from 'common/Common';
import {Http} from 'angular2/http';


@Injectable()
export class WechatService{

    constructor( private common : Common,private http:Http){}

    getWechatList(){
        return this.common.post("/wechat/list",{}).then(res=>res.json());
        );
    }

}

