package com.wei.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @GetMapping("infos")
    public String  infos(){
        System.out.println("controller");
        return "order infos";
    }
}
