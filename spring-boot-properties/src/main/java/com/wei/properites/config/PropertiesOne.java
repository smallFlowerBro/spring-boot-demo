package com.wei.properites.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Data
@Configuration
public class PropertiesOne {


    @Value("${config.properties1.param1}")
    private String param1;
    @Value("${config.properties1.param2}")
    private String param2;
}
