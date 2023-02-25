package com.wei.demo.controller;

import com.wei.demo.service.StudentService;
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
@RequestMapping("api/jpa")
public class DemoController {

    @Autowired
    private StudentService studentService;

    @GetMapping("hello")
    public  String  hello(){
        return  studentService.findAll().toString();
    }
}
