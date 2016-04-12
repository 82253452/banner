package com.banner.juhe;

import com.banner.util.HttpClientJuhe;
import com.banner.util.HttpClientUtil;
import com.github.ansell.propertyutil.PropertyUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/31 0031.
 */
@Controller
@RequestMapping("/api")
public class Joke extends BaseApi{
    @RequestMapping("/funy")
    @ResponseBody
    public  JSONObject joke(HttpServletRequest request,@RequestParam Map map){
        return Call(request,map);
    }
}
