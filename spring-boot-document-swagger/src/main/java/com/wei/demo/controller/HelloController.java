package com.wei.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */

@RestController
@RequestMapping("/api/swagger")
@Api(description = "测试管理")
public class HelloController {

    @GetMapping("hello")
    @ApiOperation(value = "测试接口一" ,notes = "这是一个测试接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名",defaultValue = "小花" )
    })
    public String  world(){
        return "hello world!";
    }
}
