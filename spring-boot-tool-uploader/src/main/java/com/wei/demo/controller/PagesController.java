package com.wei.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author weiyongjian
 * @Description 页面控制器
 * @Date
 */
@Controller
public class PagesController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }

}
