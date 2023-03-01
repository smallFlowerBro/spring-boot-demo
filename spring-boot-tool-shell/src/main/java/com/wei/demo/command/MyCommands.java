package com.wei.demo.command;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2022/4/17 9:25
 ********************************/
@ShellComponent
public class MyCommands {

    @ShellMethod(value = "Add two integers together",key = "sum")
    public  int add(int a,int b){
        return a+b;
    }
}
