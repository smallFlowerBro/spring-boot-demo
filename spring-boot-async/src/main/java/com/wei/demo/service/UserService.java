package com.wei.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Service
@EnableAsync
public class UserService {

    @Async
    public void method1(){
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    @Async
    public Future<String> method2(){
        String res="完成";
        for (int i = 0; i < 1000 ; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        return new AsyncResult<String>(res);
    }

}
