<template>
<div id="page-wrapper">
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">微信定时器</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
   <div class="col-lg-12">
       <div class="panel panel-default">
           <!-- /.panel-heading -->
           <div class="panel-heading">
               DataTables Advanced Tables
           </div>
           <div class="panel-body">
               <div class="dataTable_wrapper">
                   <div id="dataTables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="dataTables_length" id="dataTables-example_length">
                                    <label>
                                        <button type="button" class="btn btn-outline btn-default"  @click="showCreate">新建定时器</button>
                                    </label>
                                </div>
                            </div>
                        </div>
                       <div class="row">
                           <div class="col-sm-12">
                               <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                   <thead>
                                   <tr>
                                       <th>微信 appId</th>
                                       <th>微信 Secret</th>
                                       <th>启动时间</th>
                                       <th>状态</th>
                                       <th>操作</th>
                                   </tr>
                                   </thead>
                                   <tbody>
                                   <tr class="even gradeC" v-for="entity in wechatList">
                                       <td>
                                           {{entity.appId}}
                                       </td>
                                       <td>
                                           {{entity.secret}}
                                       </td>
                                       <td>
                                           {{entity.startime}}
                                       </td>
                                       <td>
                                           {{entity.state}}
                                       </td>
                                       <td>
                                           <button type="button" class="btn btn-outline btn-default" @click="update($index)">更新</button>
                                           <button type="button" class="btn btn-outline btn-default" @click="delete($index)">删除</button>
                                       </td>
                                   </tr>
                                   </tbody>
                               </table>
                           </div>
                       </div>
                       <div class="row">
                           <div class="col-lg-6">
                               <pre class="card card-block card-header">Page: {{bigCurrentPage}} / {{numPages}}</pre>
                           </div>
                           <div class="col-lg-6">
                               <pagination [totalItems]="bigTotalItems" v-model="bigCurrentPage" [maxSize]="maxSize"
                                           [boundaryLinks]="true" [rotate]="false" (numPages)="numPages = $event" (pageChanged)="pageChanged($event)"></pagination>
                           </div>
                       </div>
                   </div>
               </div>
           </div>
       </div>
   </div>
</div>
</div>
<div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="padding-top: 10%;">
    <div class="modal-dialog" role="wrapper-page" style="z-index:9999;">
        <div class="modal-content" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">定时器</h4>
            </div>
            <div class="modal-body">
                <form role="form" id="form">
                    <input class="form-control" v-model="wechatInfo.id" type="hidden">
                    <div class="form-group">
                        <label>appId</label>
                        <input class="form-control" v-model="wechatInfo.appId" type="text"  ngControl="appId" required>
                    </div>
                    <div class="form-group">
                        <label>Secret</label>
                        <input class="form-control" v-model="wechatInfo.secret" ngControl="secret" required>
                    </div>
                    <div class="form-group">
                        <label>域名</label>
                        <input class="form-control" v-model="wechatInfo.orgConn" ngControl="orgConn" required>
                    </div>
                    <div class="form-group">
                        <label>文章地址</label>
                        <input class="form-control" v-model="wechatInfo.url" ngControl="url" required>
                    </div>
                    <div class="form-group" >
                        <label>启动时间</label>
                        <!--<timepicker  v-model="mytime" (change)="changed()" [hourStep]="hstep" [minuteStep]="mstep" [showMeridian]="false"></timepicker>-->
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="input-group" >
                                    <div class="input-group-addon">时</div>
                                    <input class="form-control" v-model="wechatInfo.hour" required>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="input-group" >
                                    <div class="input-group-addon">分</div>
                                    <input class="form-control" v-model="wechatInfo.minute"  required>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button @click="add()" class="btn btn-primary">保存</button>
                </div>
            </div>
        </div>
    </div>
</div>
</template>
<script>
    import Vue from 'vue'
    import LyWeInfoService from '../../service/base/LyWeInfoService.js'
    export default {
        data(){
            return {
                wechatList:[],
                wechatInfo:{
                    appId:'',
                    secret:'',
                    orgConn:'',
                    url:'',
                    startime:'',
                    hour:'',
                    minute:''
                }
            }
        },
        ready(){
            var _self = this;
            LyWeInfoService.List(function (res) {
                _self.wechatList=res
            })
        },
        methods:{
            showCreate(){
                this.wechatInfo={
                        appId:'',
                        secret:'',
                        orgConn:'',
                        url:'',
                        id:'',
                        startime:'',
                        hour:'',
                        minute:''
                }
                $('#createModal').modal('show')
            },
            add(){
                let wechat=this.wechatInfo
                wechat.startime=wechat.hour+":"+wechat.minute+":00"
                    LyWeInfoService.add(wechat,function (data) {
                        if(data==1){
                            $('#createModal').modal('hide')
                        }
                    })
            },
            update(i){
                let data=this.wechatList[i]
                this.wechatInfo.appId=data.appId;
                this.wechatInfo.secret=data.secret;
                this.wechatInfo.orgConn=data.orgConn;
                this.wechatInfo.url=data.url;
                this.wechatInfo.id=data.id;
                this.wechatInfo.startime=data.startime;
                this.wechatInfo.hour=data.startime.split(':')[0];
                this.wechatInfo.minute=data.startime.split(':')[1];
                console.info(this.wechatInfo)
                $('#createModal').modal('show')
            },
            delete(i){
                let data=this.wechatList[i];
                this.wechatInfo.appId=data.appId;
                this.wechatInfo.secret=data.secret;
                this.wechatInfo.orgConn=data.orgConn;
                this.wechatInfo.url=data.url;
                this.wechatInfo.id=data.id;
                this.wechatInfo.startime=data.startime;
                LyWeInfoService.del(this.wechatInfo);
            }
        }
    }
</script>