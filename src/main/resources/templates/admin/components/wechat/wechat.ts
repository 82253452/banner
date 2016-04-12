import {Component,NgFor,HTTP_PROVIDERS} from 'angular2/core';
import {Http} from 'angular2/http';
import {Router,ROUTER_DIRECTIVES} from 'angular2/router';
import {WechatService} from 'service/wechat/WechatService';
import {Common} from 'common/Common';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';


@Component({
  selector: '#page-wrapper',
  templateUrl: System.baseURL+'admin/components/wechat/wechat.html',
  providers: [WechatService,Common],
  directives: [],
  pipes: []
})

export class Wechat {
  public wechatList;
  constructor(private common : Common,private wechatService : WechatService ) {
   this.wechatService.getWechatList().then(data=>
       {
         this.wechatList=data;
       }
    );
  }
}

