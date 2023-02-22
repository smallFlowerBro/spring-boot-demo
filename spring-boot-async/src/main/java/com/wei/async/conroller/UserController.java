package com.wei.async.conroller;

import com.wei.async.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RestController
@RequestMapping(value = "/api/async")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getUserInfo")
    public String getUserInfos() throws ExecutionException, InterruptedException {

        userService.method1();
        Future<String> stringFuture = userService.method2();
        System.out.println(stringFuture.get());
        return  stringFuture.get();
    }


}
