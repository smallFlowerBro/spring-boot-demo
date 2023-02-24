package com.wei.demo.controller;

import com.wei.demo.util.TemplateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/2/24 13:22
 ********************************/
@RestController
@RequestMapping("api/template")
public class DemoController  {

    @Autowired
    private TemplateKit templateKit;

    @GetMapping("hello")
    public String hello(@RequestParam(defaultValue = "default") String name){
        Map map = new HashMap<>();
        map.put("name",name);
        return templateKit.process("hello.json",map);
    }
}
