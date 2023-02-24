package com.wei.socketio.init;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Component
public class WSServerRunner implements CommandLineRunner {

    @Autowired
    private SocketIOServer socketIOServer;


    @Override
    public void run(String... args) throws Exception {
        socketIOServer.start();
    }
}
