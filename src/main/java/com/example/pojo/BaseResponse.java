package com.example.pojo;


import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

public class BaseResponse {
    static Logger logger = Logger.getLogger(BaseResponse.class.getName());

    private Integer status;
    private String reason;

    private Object data;

    public BaseResponse() {
    }

    public BaseResponse(Integer status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public BaseResponse(Integer status, String reason, Object data) {
        this.status = status;
        this.reason = reason;
        this.data = data;
    }

    public static BaseResponse success(){
        return new BaseResponse(0,"OK");
    }

    public static BaseResponse success(String reason){
        return new BaseResponse(0,reason);
    }

    public static BaseResponse success(String reason,Integer status){
        return new BaseResponse(status,reason);
    }

    public static BaseResponse success(Object data){
        if (data instanceof JSON){
            return new BaseResponse(0,"OK",data);
        }else{
            return new BaseResponse(0,"OK",JSON.toJSON(data));
        }
    }

    public static BaseResponse fail(String reason){
        return new BaseResponse(1,reason);
    }

    public static BaseResponse error(Exception exception){
        logger.error(exception.getMessage());
        return new BaseResponse(1,"系统错误！");
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
