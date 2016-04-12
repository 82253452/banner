import {Component} from 'angular2/core';
import {Router, Route, RouteConfig, ROUTER_DIRECTIVES} from 'angular2/router';
import {Home} from 'components/home/home';
import {Wechat} from 'components/wechat/wechat';

@Component({
    selector: '#page-wrapper',
    providers: [],
    templateUrl:System.baseURL+'components/wechat/wechat.html',
    directives: [],
    pipes: []
})

@RouteConfig([
    new Route({ path: '/home', component: Home, name: 'Home', useAsDefault: true}),
    new Route({ path: '/wechat', component: Wechat, name: 'Wechat'}),
])
export class app {

    constructor() {}

}
