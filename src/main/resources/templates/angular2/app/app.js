import {bootstrap, ChangeDetection, jitChangeDetection} from 'angular2/angular2';
import {bind} from 'angular2/di';
import {Calendar} from 'components/calendar/calendar';
import {Wechat} from 'components/wechat/wechat';
import {CalendarCell} from 'components/calendar-cell/calendar-cell';

export function main() {
  return bootstrap(Wechat);
}
