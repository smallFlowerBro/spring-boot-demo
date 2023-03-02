package com.wei.demo.controller;

import com.wei.demo.lib.MyMath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/3/2 14:27
 ********************************/
@RestController
@RequestMapping("api/jna")
public class DemoController {

    @GetMapping("add")
    public String add(@RequestParam("a") int a,@RequestParam("b") int b){
        return String.valueOf(MyMath.INSTANCE.add(a,b));
    }

}
