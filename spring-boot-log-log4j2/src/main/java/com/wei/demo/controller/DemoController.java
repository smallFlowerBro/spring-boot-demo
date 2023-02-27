package com.wei.demo.controller;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/2/27 10:10
 ********************************/
@RestController
@RequestMapping("api/log4j2")
@Log4j2
public class DemoController {

    @GetMapping("hello")
    private String hello(@RequestParam String deviceNo){

//        MDC.put("deviceNo",deviceNo);
        ThreadContext.put("deviceNo",deviceNo);
        log.info("进入hello");
        return "hello";
    }


}
