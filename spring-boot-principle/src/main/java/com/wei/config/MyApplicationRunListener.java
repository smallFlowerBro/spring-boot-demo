package com.wei.config;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2024/3/25 13:43
 *   海到尽头天作岸 山登绝顶我为峰
 ********************************/
public class MyApplicationRunListener implements SpringApplicationRunListener {
    public MyApplicationRunListener(SpringApplication app,String arg[]) {
        System.out.println("构建完成");
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("MyApplicationRunListener starting");
    }

    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("environmentPrepared");
    }
}
