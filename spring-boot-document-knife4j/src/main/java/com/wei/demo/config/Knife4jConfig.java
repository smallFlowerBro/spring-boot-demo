package com.wei.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

/*********************************
 *   @Author WEIYJ
 *   @Description knife4j文档配置
 *   @Data 2023/2/7 21:43
 ********************************/

@OpenAPIDefinition(info = @Info(title = "接口文档",description = "博客网站接口文档",contact = @Contact(name = "小花",email = "1262405508@qq.com"),version = "v1"))
public class Knife4jConfig {

}
