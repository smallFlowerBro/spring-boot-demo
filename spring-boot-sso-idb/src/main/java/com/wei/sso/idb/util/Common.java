package com.wei.sso.idb.util;

import io.netty.handler.codec.base64.Base64Encoder;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.Random;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public class Common {

    public  static String getToken(){
        String token =(System.currentTimeMillis()+new Random().nextInt(999999999))+"";
        try{
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] digest = md.digest(token.getBytes());
            BASE64Encoder base64Encoder = new BASE64Encoder();
            return  base64Encoder.encode(digest);
        }catch (Exception e){}
        return "";
    }

}
