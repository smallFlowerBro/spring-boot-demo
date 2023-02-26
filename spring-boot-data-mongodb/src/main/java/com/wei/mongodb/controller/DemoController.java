package com.wei.mongodb.controller;

import com.wei.mongodb.entity.UserEntity;
import com.wei.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/2/26 0:13
 ********************************/
@RestController
@RequestMapping("api/mongodb")
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("save")
    public  String  save(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("xiaohua");
        userEntity.setId("001");
        UserEntity save = userService.save(userEntity);
        return  save==null?"false":"true";
    }

    @GetMapping("get")
    public String getUser(@RequestParam String id){
        return userService.findById(id).toString();
    }
}
