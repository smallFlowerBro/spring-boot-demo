package com.wei.springbootaop.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @Author weiyongjian
 * @Description //aop 切面类
 * @Date
 */
@Aspect
@Component
public class ControllerAspect {

    @Pointcut("execution(public * com.wei.springbootaop.controller.*.*(..))")
    public void pointCut(){}


    @Before("pointCut()")
    public  void beforePointCut(JoinPoint joinPoint){
        //获取request对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取到参数
        Object[] args = joinPoint.getArgs();
        //获取url地址
        String requestURI = request.getRequestURI();


        System.out.println("controller:"+requestURI);
    }

    @After("pointCut()")
    public  void afterPointCut(){
        System.out.println("控制器请求结束");
    }
}
