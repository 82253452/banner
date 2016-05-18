import Common from '../../common/Common.js'

export default {
    pageList(param,fun){
        return Common.post("/lyWeInfo/pageList",param,function (res) {
            fun(res);
        });
    },
    List(fun){
        return Common.post("/lyWeInfo/list",{},function (res) {
             fun(res);
         });
    },
    add(data,fun){
        return Common.post("/lyWeInfo/add",data,function (res) {
              fun(res);
        });
    },
    del(data,fun){
        return Common.post("/lyWeInfo/del",data,function (res) {
            fun(res);
        });
    },
    update(data,fun){
        return Common.post("/lyWeInfo/update",data,function (res) {
             fun(res);
      });
    },
    getById(data,fun){
        return Common.post("/lyWeInfo/getById",data,function (res) {
                 fun(res);
            });
        }
}