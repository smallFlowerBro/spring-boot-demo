package com.wei.serverone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RestController
@RequestMapping("/api/test")
public class ServerTestController {

    @GetMapping("demo1")
    public  String demo1(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for (int i = 0; i <cookies.length ; i++) {
                System.out.println(cookies[i].getName()+";"+cookies[i].getValue());
            }
        }else{
            System.out.println("没有cookie");
            Cookie cookie = new Cookie("username","xiaohua");
            response.addCookie(cookie);
        }

        return "Hello";
    }
}
