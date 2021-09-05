package com.wei.itexpdf.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author weiyongjian
 * @Description
 * @Date
 */
public class Response {

    /**
     * 成功
     * @return
     */
    public  static Map<String,Object>  createSuccessResponse(){ return Response.createSuccessResponseAndData(null); }
    /**
     * 失败
     * @return
     */
    public  static Map<String,Object>  createErrorResponse(){
        return Response.createErrorResponseAndData(null);
    }
    /**
     * 失败，带数据
     * @return
     */
    public  static Map<String,Object>  createErrorResponseAndData(Object obj){
        Map response =  new HashMap<String,Object>();
        response.put("code",ResponseEnum.ERROR.getCode());
        response.put("msg",ResponseEnum.ERROR.getMsg());
        if(obj!=null) response.put("data",obj);
        return response;
    }
    /**
     * 成功，带数据
     * @return
     */
    public  static Map<String,Object>  createSuccessResponseAndData(Object obj){
        Map response =  new HashMap<String,Object>();
        response.put("code",ResponseEnum.SUCCESS.getCode());
        response.put("msg",ResponseEnum.SUCCESS.getMsg());
        if(obj!=null) response.put("data",obj);
        return response;
    }
}
