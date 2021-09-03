package com.wei.netty.config;

import com.wei.netty.client.TimeClient;
import com.wei.netty.server.DiscardServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */

@Configuration
@Slf4j
public class NettyStart implements CommandLineRunner {
    @Autowired
    private DiscardServer discardServer;
    @Autowired
    private TimeClient timeClient;

    @Override
    public void run(String... args) throws Exception {
        log.info("netty run>>>>>>>>>>>>");
        discardServer.run();

        timeClient.run();
    }
}
