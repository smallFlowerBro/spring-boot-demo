package com.wei.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2024/4/3 14:19
 *   海到尽头天作岸 山登绝顶我为峰
 ********************************/
@Component
@Data
public class CommandLineParamBean {
    @Value("${commandName:HUA}")
    private String commandName;

}
