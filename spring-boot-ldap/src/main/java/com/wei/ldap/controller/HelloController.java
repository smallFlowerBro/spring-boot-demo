package com.wei.ldap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @GetMapping("index")
    public String index(){
        return "Welcome to the home page!";
    }
}
