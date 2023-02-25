package com.wei.demo.controller;

import com.wei.demo.util.IRedisOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/2/26 0:13
 ********************************/
@RestController
@RequestMapping("api/redis")
public class DemoController  {

    @Autowired
    private IRedisOption iRedisOption;

    @GetMapping("hello")
    public  String  hello(){
        if(iRedisOption.hasKey("name")){
            return "来自redis:"+iRedisOption.get("name");
        }else{
            iRedisOption.set("name","xiaohua");
            return "默认值:小草";
        }
    }
}
