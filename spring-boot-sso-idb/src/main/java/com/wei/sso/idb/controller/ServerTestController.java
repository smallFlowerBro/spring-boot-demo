package com.wei.sso.idb.controller;

import com.wei.sso.idb.db.entity.UserEntity;
import com.wei.sso.idb.db.repository.UserRepository;
import com.wei.sso.idb.service.UserService;
import com.wei.sso.idb.util.Common;
import com.wei.sso.idb.util.RedisOP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RestController
@RequestMapping("/idb")
public class ServerTestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RedisOP redisOP;

    @GetMapping("doLogin")
    public Map<String,String> doLogin(HttpServletRequest request,
                                      @RequestParam("user_name") String user_name,
                                      @RequestParam("pwd") String pwd){
        UserEntity byUserNameAndPassword = userRepository.findByUserNameAndPassword(user_name, pwd);
        Map<String,String> res = new HashMap<String, String>();
        if(byUserNameAndPassword!=null){
            String token= Common.getToken();
            res.put("succssflag","0");
            res.put("token",token);
            redisOP.set(token,true);
        }else{
            res.put("succssflag","1");
        }
        return res;
    }



    @GetMapping("isLogin")
    public String isLogin(String token){
        if(userService.isLogin(token)){
            return "TRUE";
        }else{
            return "FALSE";
        }
    }
}
