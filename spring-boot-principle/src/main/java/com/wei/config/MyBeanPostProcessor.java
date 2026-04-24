package com.wei.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2024/3/14 16:15
 *   海到尽头天作岸 山登绝顶我为峰
 ********************************/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof OssClient){
            System.out.println("正在执行 postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof OssClient){
            System.out.println("正在执行 postProcessAfterInitialization");
        }

        if(bean instanceof CommandLineParamBean){
            System.out.println(bean);
            System.out.println("commandName:"+((CommandLineParamBean) bean).getCommandName());
        }
        return bean;
    }
}
