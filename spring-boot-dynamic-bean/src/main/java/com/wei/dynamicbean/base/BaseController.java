package com.wei.dynamicbean.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class BaseController implements ApplicationContextAware {
    private static  ApplicationContext applicationContext;
    public String getServiceName(String deviceNo) {
        if("device_1".equals(deviceNo)){
            return "service1";
        }else{
            return "service2";
        }
}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("初始化完成");
        BaseController.applicationContext = applicationContext;
    }

    public BaseTrade getTrade(String deviceNoe){
        BaseTrade bean = (BaseTrade) applicationContext.getBean(getServiceName(deviceNoe));
        return  bean;
    }
}
