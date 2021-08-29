package com.wei.dynamicbean.controller;

import com.wei.dynamicbean.base.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RestController
@RequestMapping("/user")
public class TestController extends BaseController {
    @GetMapping("test")
    public String test(@RequestParam("deviceNo") String deviceNo){
        getTrade(deviceNo).send();
        return "xxx";
    }
}
