package com.wei.threadsafe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2022/8/18 14:08
 ********************************/
@RestController
@RequestMapping("/safe2")
public class SubControllerTwo extends  BaseController {
    @GetMapping("two")
    public String one(){

        System.out.println("two>>>>>>"+p_param);
        return "two";
    }
}
