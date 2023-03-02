package com.wei.demo.config;

import com.sun.xml.internal.ws.transport.http.server.EndpointImpl;
import com.wei.demo.service.MyService;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @Author weiyongjian
 * @Description //demo 配置
 * @Date
 */
@Configuration
public class WSConfig {

    @Bean
    @ConfigurationProperties(prefix = "ws")
    public WSProperties getWSProperties(){
        return  new WSProperties();
    }


    @Bean
    public Endpoint getEndPoint(WSProperties wsProperties){
        String url ="http://"+wsProperties.getHost()+":"+wsProperties.getPort()+"/request";
        Endpoint endpoint = EndpointImpl.publish(url, new MyService());
        System.out.println(url+"?wsdl");
        return endpoint;
    }



}
