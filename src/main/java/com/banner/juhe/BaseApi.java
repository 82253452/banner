package com.banner.juhe;

import com.banner.util.HttpClientJuhe;
import net.sf.json.JSONObject;
import org.apache.http.HttpRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/1 0001.
 */
public class BaseApi {
    public final String apiPre="api";
    public void before(HttpServletRequest request,Map map){

    }
    public JSONObject execute(HttpServletRequest request,Map map){
        JSONObject result=null;
        String requestMapping=request.getRequestURI();
        JSONObject apiJson=getApi(requestMapping);
        if(apiJson!=null){
            String method=apiJson.getString("method");
            String api=apiJson.getString("api");
            result = HttpClientJuhe.juheApi(api, map, method);
        }
        return result;
    }
    public JSONObject after(JSONObject json){
        return json;
    }
    public JSONObject Call(HttpServletRequest request,Map map){
        before(request,map);
        JSONObject json=execute(request, map);
        json=after(json);
        return  json;
    }
    private JSONObject getApi(String requestMapping){
        JSONObject jsonObject=null;
        String api=requestMapping.replaceAll("/", ".");
        api=api.substring(1, api.length());
        String apiGet=CommonJuhe.propertyUtil.get(api+".get","");
        String apiPost=CommonJuhe.propertyUtil.get(api+".post","");
        if (!"".equals(apiGet)){
            jsonObject=new JSONObject();
            jsonObject.put("method","GET");
            jsonObject.put("api",apiGet);
        }else if(!"".equals(apiPost)){
            jsonObject=new JSONObject();
            jsonObject.put("method","POST");
            jsonObject.put("api",apiPost);
        }
        return jsonObject;
    }
    public static void main(String args[]){
        String s=".123.23";
        System.out.print(s.substring(1,s.length()));
    }
}
