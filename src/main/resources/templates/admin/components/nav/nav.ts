import {Component, NgFor, click, HTTP_PROVIDERS} from 'angular2/core';
import {Router,ROUTER_DIRECTIVES} from 'angular2/router';
import {LyWeInfoService} from 'service/base/LyWeInfoService';
import {Common} from 'common/Common';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';

@Component({
  selector: 'navigation-page',
  templateUrl: System.baseURL+'admin/components/nav/nav.html',
  providers: [LyWeInfoService,Common],
  directives: [],
  pipes: []
})

export class navigation {
    public navList=[{
        name:'微信',
        url:'weichat.html'
    }]
    constructor(
        private common : Common ,
        private wechatService : LyWeInfoService
    ) {

    }

    
}

