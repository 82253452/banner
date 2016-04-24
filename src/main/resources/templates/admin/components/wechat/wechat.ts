import {Component, NgFor, click, HTTP_PROVIDERS} from 'angular2/core';
import { FORM_DIRECTIVES,CORE_DIRECTIVES } from 'angular2/common';
import { Alert,ACCORDION_DIRECTIVES,PAGINATION_DIRECTIVES,Timepicker} from 'ng2bootstrap/ng2-bootstrap';
import {Router,ROUTER_DIRECTIVES} from 'angular2/router';
import {LyWeInfoService} from 'service/base/LyWeInfoService';
import {Common} from 'common/Common';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';

@Component({
  selector: '#page-wrapper',
  templateUrl: System.baseURL+'admin/components/wechat/wechat.html',
  providers: [LyWeInfoService,Common],
  directives: [FORM_DIRECTIVES,CORE_DIRECTIVES,ACCORDION_DIRECTIVES,Alert,PAGINATION_DIRECTIVES,Timepicker],
  pipes: []
})

export class Wechat {
    public wechatList;
    public wechatInfo:any={}

    public totalItems:number = 0;
    public currentPage:number = 1;
    public maxSize:number = 10;
    public bigCurrentPage:number = 1;
    public numPages:number = 1;

    public hstep:number = 1;
    public mstep:number = 1;
    public mytime:Date = new Date();

    constructor(
        private common : Common ,
        private wechatService : LyWeInfoService
    ) {
        this.wechatService.pageList(this.currentPage,this.maxSize).then(data=>
        {
            this.wechatList=data.list;
            this.totalItems=data.total;
        });
    }

    public setPage(pageNo:number):void {
        this.currentPage = pageNo;
    };

    public pageChanged(event:any):void {
        this.wechatService.pageList(event.page,this.maxSize).then(data=>
        {
            this.wechatList=data.list;
            this.currentPage=data.pageNum;
        });

    };
    public add(wechat){
        wechat.startime=wechat.hour+":"+wechat.minute+":00";
       this.wechatService.add(wechat).then(data=>{
            if(data==1){
                $('#createModal').modal('hide')
            }
        });
    }
    public create():void{
        $('#createModal').modal('show')
    }
    public update(i):void{
        this.wechatInfo=this.wechatList[i];
        $('#createModal').modal('show')
    }
    public delete(i):void{
        this.wechatInfo=this.wechatList[i];
        this.wechatService.del(this.wechatInfo);
    }
    public addItem():void {
        this.items.push(`Items ${this.items.length + 1}`);
    }
    public changed():void{
        console.info(this.mytime);
    }
    
}

