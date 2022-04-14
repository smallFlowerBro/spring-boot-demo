package com.wei.shiro.handler;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler({AuthorizationException.class})
    @ResponseStatus(HttpStatus.OK)
    public String AuthorizationException(){
        return "没有权限";
    }
    @ExceptionHandler({ UnknownAccountException.class})
    @ResponseStatus(HttpStatus.OK)
    public String UnknownAccountException(){ return "查无此人"; }
    @ExceptionHandler({IncorrectCredentialsException.class})
    @ResponseStatus(HttpStatus.OK)
    public String handleUnknownAccount(){ return "密码错误"; }
}
