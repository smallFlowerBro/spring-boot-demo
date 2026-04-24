package com.wei.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2024/3/14 11:25
 *   海到尽头天作岸 山登绝顶我为峰
 ********************************/
@Component
public class OssClient implements  InitializingBean, DisposableBean {

    private String value;

    public OssClient() {
        System.out.println("构造函数 执行了");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化后执行");
    }
    @PostConstruct
    public void  posCar(){
        System.out.println("@PostConstruct 执行了");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("正在销毁该Bean对象 ");
    }
}
