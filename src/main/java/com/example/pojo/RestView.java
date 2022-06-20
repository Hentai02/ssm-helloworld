package com.example.pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class RestView implements View {

    private Object data;

    public RestView(){}

    public RestView(Object data){
        this.data = data;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        JSONObject jresp = new JSONObject(true);
        int status = response.getStatus();
        jresp.put("status",status);
        if (status >= 200)
            jresp.put("reason","OK");
        if(data != null){
            if (data instanceof JSON){
                jresp.put("data",data);
            }else{
                jresp.put("data",JSON.toJSON(data));
            }
        }
        response.setContentType("application/json");
        request.setCharacterEncoding("UTF-8");
        response.getWriter().write(JSON.toJSONString(jresp));
    }
}
