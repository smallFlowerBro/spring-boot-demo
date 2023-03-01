package com.wei.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/3/1 13:11
 ********************************/
@RestController
@RequestMapping("api/admin")
public class DemoController {

    @GetMapping("insert")
    public String insert(){
        return "insert";
    }
}
