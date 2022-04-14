package com.wei.shiro.contoller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotEmpty;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("login.html")
    public String login(){
        return "登录界面";
    }

    @GetMapping("doLogin")
    public String doLogin(@NotEmpty(message = "用户名不得为空") String username,
                          @NotEmpty(message = "密码不得为空") String password){
        SecurityUtils
                .getSubject()
                .login(new UsernamePasswordToken(username,password));
        return "登录成功";
    }


    @GetMapping("logout")
    public String logOut(){
        SecurityUtils
                .getSubject()
                .logout();
        return "退出成功";
    }
}
