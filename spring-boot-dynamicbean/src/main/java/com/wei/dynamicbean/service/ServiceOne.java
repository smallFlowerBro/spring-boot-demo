package com.wei.dynamicbean.service;

import com.wei.dynamicbean.base.BaseTrade;
import org.springframework.stereotype.Component;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Component("service1")
public class ServiceOne implements BaseTrade {
    @Override
    public void send() {
        System.out.println("我是service1");
    }
}
