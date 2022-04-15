package com.wei.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Endpoint;

@RestController
@SpringBootApplication
public class SpringBootWebServiceApplication {

    @Autowired
    private Endpoint endpoint;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebServiceApplication.class, args);
    }

    @RequestMapping
    public void startEndpoint(){
        endpoint.toString();
    }
}
