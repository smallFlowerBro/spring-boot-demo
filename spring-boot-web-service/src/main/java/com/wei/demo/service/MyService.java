package com.wei.demo.service;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@WebService(endpointInterface = "com.wei.demo.service.MyService")
public class MyService implements IService {

    @Override
    public String request(@WebParam(name = "tradeType") String tradeType,@WebParam(name="tradeContent") String tradeContent) {
        System.out.println(tradeType);
        System.out.println(tradeContent);
        return "调用成功";
    }
}
