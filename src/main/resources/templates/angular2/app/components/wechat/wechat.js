import {Component, Foreach, Template, If} from 'angular2/angular2';


@Component({
  selector: 'wechat',
})
@Template({
  url: System.baseURL+'angular2/app/components/wechat/wechat.html',
  directives: [
    Foreach,
    If
  ]
})
export class Wechat {
  constructor() {
    alert(33);
  }
  load() {

  }
  searchAll() {
    /*searchAllCells();*/
  }
  dayHeaderClicked() {
    alert('dayHeaderClicked()');
  }
}
