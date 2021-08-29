package com.wei.dynamicbean.service;

import com.wei.dynamicbean.base.BaseTrade;
import org.springframework.stereotype.Service;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Service("service2")
public class ServiceTwo  implements BaseTrade {
    @Override
    public void send() {
        System.out.println("我是service2");
    }
}
