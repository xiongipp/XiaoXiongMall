/*
* 自定义Ajax,统一api接口
* */
class Ajax {
    vueObj=null;
    baseUrl="http://localhost:8081/";
    constructor(vueObj){
        this.vueObj=vueObj;
    }
    get(api,callback,params){
        let url=this.baseUrl+api;/*真实请求的api*/
        console.log(url);
        let data=JSON.stringify(params);/*json对象转为字符串*/
        this.vueObj.$http.get(url,data,{emulateJSON:true}).then(
            res=>{
                callback(res.body);/*回调函数传回服务器发过来的结果*/
            }
        ).catch(err => {
            console.log(err)
        });
    }
    delete(api,callback,params){
        let url=this.baseUrl+api;
        let data=JSON.stringify(params);
        this.vueObj.$http.delete(url,data,{emulateJSON:true}).then(
            res=>{
                callback(res.body)
            }
        ).catch(err=>{
            console.log(err)
        })
    }
    post(api,callback,params){
        let url=this.baseUrl+api;
        let data=JSON.stringify(params);
        this.vueObj.$http.post(url,data,{emulateJSON:true}).then(
            res=>{
                callback(res.body)
            }
        ).catch(err=>{
            console.log(err)
        })
    }
    put(api,callback,params){
        let url=this.baseUrl+api;
        let data=JSON.stringify(params);
        this.vueObj.$http.put(url,data,{emulateJSON:true}).then(
            res=>{
                callback(res.body)
            }
        ).catch(err=>{
            console.log(err)
        })
    }

}