package com.wei.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SpringBootCloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCloudZuulApplication.class, args);
    }

}
