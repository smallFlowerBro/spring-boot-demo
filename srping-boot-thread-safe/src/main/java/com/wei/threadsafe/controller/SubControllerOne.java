package com.wei.threadsafe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2022/8/18 14:06
 ********************************/
@RestController
@RequestMapping("/safe")
public class SubControllerOne extends BaseController {

    @GetMapping("one")
    public String one(){

        System.out.println("one>>>>>>"+p_param);
        return "one";
    }

}
