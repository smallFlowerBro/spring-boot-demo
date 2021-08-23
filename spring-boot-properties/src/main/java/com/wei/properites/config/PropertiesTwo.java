package com.wei.properites.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@ConfigurationProperties(prefix = "config.properties2")
@Configuration
@Data
public class PropertiesTwo {
    /*参数1*/
    private String param1;
    /*参数2*/
    private String param2;

}
