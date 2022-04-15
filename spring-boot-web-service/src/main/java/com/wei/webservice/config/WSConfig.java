package com.wei.webservice.config;

import com.sun.xml.internal.ws.transport.http.server.EndpointImpl;
import com.wei.webservice.service.MyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @Author weiyongjian
 * @Description //webservice 配置
 * @Date
 */
@Configuration
public class WSConfig {

    @Bean
    public Endpoint getEndPoint(){
        System.out.println("正在发布");
        Endpoint publish = EndpointImpl.publish("http://localhost:8090/show", new MyService());
        return publish;
    }
}
