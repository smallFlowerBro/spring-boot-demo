package com.wei.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2024/3/22 15:22
 *   海到尽头天作岸 山登绝顶我为峰
 ********************************/
public class LearnApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("容器中初始化的Bean的数量"+applicationContext.getBeanDefinitionCount());
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
