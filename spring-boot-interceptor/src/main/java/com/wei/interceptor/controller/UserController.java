package com.wei.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping("infos")
    public Map<String,String> world(){
        return  new HashMap<String, String>(){{
            put("name","xiaohua");
            put("age","26");
        }};
    }
    @GetMapping("login")
    public String login(){
        System.out.println("xxx");
        return "登录成功！";
    }
}
