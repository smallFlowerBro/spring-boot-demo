package com.wei.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2024/4/9 10:15
 *   海到尽头天作岸 山登绝顶我为峰
 ********************************/
@Configuration
@AutoConfiguration
@Import(DIYRegisterAutoConfiguration.DIYClass.class)
public class DIYRegisterAutoConfiguration {

    public DIYRegisterAutoConfiguration() {
        System.out.println("DIYRegisterAutoConfiguration 初始化了");
    }

    public static class DIYClass{
        public DIYClass() {
            System.out.println("DIYClass初始化了");
        }



    }

}
