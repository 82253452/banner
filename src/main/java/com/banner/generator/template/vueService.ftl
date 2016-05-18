import Common from '../common/Common.js'

export default {
    pageList(param,fun){
        return Common.post("/${entityName}/pageList",param,function (res) {
              fun(res);
        });
    },
    List(fun){
        return Common.post("/${entityName}/list",{},function (res) {
             fun(res);
         });
    },
    add(data,fun){
        return Common.post("/${entityName}/add",data,function (res) {
              fun(res);
        });
    },
    del(data,fun){
        return Common.post("/${entityName}/del",data,function (res) {
            fun(res);
        });
    },
    update(data,fun){
        return Common.post("/${entityName}/update",data,function (res) {
             fun(res);
      });
    },
    getById(data,fun){
        return Common.post("/${entityName}/getById",data,function (res) {
                 fun(res);
            });
        }
}