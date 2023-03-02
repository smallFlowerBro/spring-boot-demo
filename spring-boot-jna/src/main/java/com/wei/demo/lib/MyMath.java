package com.wei.demo.lib;

import com.sun.jna.Library;
import com.sun.jna.Native;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/3/2 13:26
 ********************************/
public interface MyMath extends Library {

    MyMath INSTANCE = Native.load("javademo.dll", MyMath.class);

    int add(int a,int b);
}
