import {Component} from 'angular2/core';
import {Router} from 'angular2/router';
import {navigation} from 'components/nav/nav';
import {Wechat} from 'components/wechat/wechat';



@Component({
  selector: 'load-page',
  templateUrl: System.baseURL+'admin/components/home/home.html',
  providers: [],
  directives: [navigation,Wechat],
  pipes: []
})

export class Home {

}

