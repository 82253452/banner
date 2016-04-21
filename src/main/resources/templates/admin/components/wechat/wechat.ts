import {Component, NgFor, click, HTTP_PROVIDERS} from 'angular2/core';
import { FORM_DIRECTIVES } from 'angular2/common';
import {Http} from 'angular2/http';
import {Router,ROUTER_DIRECTIVES} from 'angular2/router';
import {LyWeInfoService} from 'service/base/LyWeInfoService';
import {Common} from 'common/Common';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';


@Component({
  selector: '#page-wrapper',
  templateUrl: System.baseURL+'admin/components/wechat/wechat.html',
  providers: [LyWeInfoService,Common],
  directives: [FORM_DIRECTIVES],
  pipes: []
})

export class Wechat {
  public wechatList;
  constructor(
      private common : Common ,
      private wechatService : LyWeInfoService
  ) {
   this.wechatService.List().then(data=>
       {
         this.wechatList=data;
       }
   );
      }
    add(wechat){
        console.info(wechat);
        this.wechatService.add(wechat).then(data=>{
            console.info(data);
        });
    }
}

