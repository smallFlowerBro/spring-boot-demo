package com.wei.springbootaop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author weiyongjian
 * @Description Hello 控制器
 * @Date
 */
@RestController
@RequestMapping(value = "/api/aop")
public class HelloController {

    @GetMapping("world")
    public String world(){
        System.out.println("Hello world");
        return "Hello world";
    }

}
