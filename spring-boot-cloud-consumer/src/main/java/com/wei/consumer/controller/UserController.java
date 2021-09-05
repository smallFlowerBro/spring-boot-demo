package com.wei.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/getUserInfo")
    public  String  getUserInfo(){
        String url="http://spring-boot-cloud-provider/user/getUserInfo";

        return  restTemplate.getForObject(url,String.class);
    }

}
