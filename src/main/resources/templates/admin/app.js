import {bootstrap} from 'angular2/platform/browser';
import {HTTP_PROVIDERS} from 'angular2/http';
import {ROUTER_PROVIDERS} from 'angular2/router';
import {app} from './app';
import {Wechat} from 'components/wechat/wechat';


/*export function main() {
  return bootstrap(Wechat);
}*/
bootstrap(Wechat, [HTTP_PROVIDERS, ROUTER_PROVIDERS])
    .catch(err => console.error(err));
