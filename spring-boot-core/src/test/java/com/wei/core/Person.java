package com.wei.core;

import lombok.Data;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Data
public abstract class Person {
    private String sex;
    private String name;
    private int age;
    public void run(){
        System.out.println("I am"+name+" I can run");
    }
}
