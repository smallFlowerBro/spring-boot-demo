package com.wei.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author weiyongjian
 * @Description 跨源资源共享控制器
 * @Date
 */
@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class CORSController {

    @GetMapping("hello")
    public String index(){
        return "Hello world!";
    }
}
