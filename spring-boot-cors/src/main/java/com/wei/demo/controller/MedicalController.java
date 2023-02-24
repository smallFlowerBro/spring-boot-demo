package com.wei.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2022/4/29 12:42
 ********************************/
@RestController
public class MedicalController {

    @PostMapping(value = "ReadCardBas")
    public String ReadCardBas(){
        return "-1@错误";
    }

    @PostMapping(value = "EcQuery")
    public String EcQuery(){
        return "-1@错误";
    }
}
