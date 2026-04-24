package com.wei.sso.idb.service;

import com.wei.sso.idb.util.RedisOP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Service
public class UserService {
    @Autowired
    private RedisOP redisOP;

    public boolean isLogin(String token){
        String _token=String.valueOf(redisOP.get(token));
        if(_token!=null&&new Boolean(_token)){
            return true;
        }else {
            return false;
        }
    }
}
