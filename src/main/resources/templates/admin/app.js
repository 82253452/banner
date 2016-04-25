import {bootstrap} from 'angular2/platform/browser';
import {HTTP_PROVIDERS} from 'angular2/http';
import {ROUTER_PROVIDERS} from 'angular2/router';
import {Home} from 'components/home/home';


/*export function main() {
  return bootstrap(Wechat);
}*/
bootstrap(Home, [HTTP_PROVIDERS, ROUTER_PROVIDERS])
    .catch(err => console.error(err));
