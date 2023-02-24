package com.wei.socketio.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author weiyongjian
 * @Description
 * @Date
 */
@ConfigurationProperties(prefix = "ws.server")
@Data
public class Config {
    /*服务器ip*/
    private String ip;
    /*端口*/
    private int port;
}
