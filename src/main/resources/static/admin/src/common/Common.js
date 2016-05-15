import Vue from 'vue'
Vue.use(require('vue-resource'));
export default{
    post(url,data,fun){
         return Vue.http.post(url, data).then(function (response) {
             // success callback
             fun(response.data);
         }, function (response) {
            // error callback
         });
    },
    get(url,data,fun){
        return Vue.http.get(url, data).then(function (response) {
            // success callback
            fun(response);
        }, function (response) {
            // error callback
        });
    }
}