package com.wei.demo.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Configuration
public class YourInterceptor implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new UserInterceptor())
                .excludePathPatterns("/user/login");
    }
}
