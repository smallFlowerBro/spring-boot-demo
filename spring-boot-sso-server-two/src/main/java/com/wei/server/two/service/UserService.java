package com.wei.server.two.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.embedded.undertow.HttpHandlerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author weiyongjian
 * @Description 用户业务层
 * @Date
 */
@Service
@ConfigurationProperties(prefix = "trade")
public class UserService {

    private String sso_url;


    @GetMapping("doLogin")
    public String doLogin( String user_name,String pwd){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(sso_url+"doLogin?user_name="+user_name+"&pwd="+pwd);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if(response!=null){
                String s = EntityUtils.toString(entity);
                return s;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    @GetMapping("isLogin")
    public String isLogin(String token){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(sso_url+"isLogin?token="+token);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if(response!=null){
                String s = EntityUtils.toString(entity);
                return s;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
