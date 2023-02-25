package com.wei.demo.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class RedisUtil implements IRedisOption {

    private RedisTemplate redisTemplate;
    public RedisUtil(RedisTemplate redisTemplate){
        this.redisTemplate=redisTemplate;
    }

    @Override
    public boolean expire(String key, int second) {
        try {
            if(second>0){
                redisTemplate.expire(key,second, TimeUnit.SECONDS);
            }else{
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }
    @Override
    public void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }
    @Override
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public Object get(String key) {

        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
