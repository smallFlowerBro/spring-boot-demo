package com.wei.webservice.service;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@WebService(endpointInterface = "com.wei.webservice.service.MyService")
public class MyService implements IService {

    @Override
    public String show(@WebParam(name = "params") String params) {
        System.out.println(params);
        return "调用成功";
    }
}
