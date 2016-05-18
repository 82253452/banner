import Common from '../common/Common.js'
export default{
    pageList(fun){
        return Common.post("/lyWeInfo/pageList",{},function (res) {
            fun(res);
        });
    },
    List(fun){
         return Common.post("/lyWeInfo/list",{},function (res) {
             fun(res);
         });
    },
    add(data){
         return this.Common.post("/lyWeInfo/add",data).then();
    },
    del(data){
         return this.Common.post("/lyWeInfo/del",data).then();
    },
    update(data){
          return this.Common.post("/lyWeInfo/update",data).then();
    },
    getById(data){
          return this.Common.post("/lyWeInfo/getById",data).then(res=>res.json());
    }

}


