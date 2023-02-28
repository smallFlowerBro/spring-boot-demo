package com.wei.threadsafe.controller;

import org.springframework.stereotype.Component;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2022/8/18 14:05
 ********************************/
public class BaseController {
    public String p_param = "parent/"+getName();

    private String getName() {
        return this.getClass().getName();
    }

    public static void main(String[] args) {
        String hello = new String("hello");
        String hello2 = new String("hello");
        System.out.println(hello.equals(hello2));
    }

}
