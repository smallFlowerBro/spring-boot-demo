package com.wei.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/2/24 14:21
 ********************************/
@RestController
@RequestMapping("api/knife4j")
@Tag(name = "测试接口")
public class BodyController {

    @Operation(summary = "普通请求")
    @PostMapping("/hello")
    public String body(){
        return "hello world";
    }


}
