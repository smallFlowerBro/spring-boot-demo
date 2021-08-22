package com.wei.springbootaop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author weiyongjian
 * @Description Hello 控制器
 * @Date
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping("world")
    public String world(){
        return "Hello world";
    }

}
