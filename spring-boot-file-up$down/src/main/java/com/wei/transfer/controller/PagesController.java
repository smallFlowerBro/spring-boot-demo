package com.wei.transfer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author weiyongjian
 * @Description 页面控制器
 * @Date
 */
@RestController
public class PagesController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }

}
