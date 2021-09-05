package com.wei.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("getUserInfo")
    public String getUserInfo(){
        System.out.println("I am a provider!");
        return "xxx";
    }

}
