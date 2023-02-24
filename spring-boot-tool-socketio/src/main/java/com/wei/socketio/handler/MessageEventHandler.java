package com.wei.socketio.handler;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.wei.socketio.config.Event;
import com.wei.socketio.messageconstructure.GroupMsg;
import com.wei.socketio.messageconstructure.JoinRequest;
import com.wei.socketio.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Component
@Slf4j
public class MessageEventHandler {
    @Autowired
    private SocketIOServer server;
    @Autowired
    private RedisUtils redisUtils;

    @OnConnect
    public void onConnect(SocketIOClient client){
        if(client!=null){
            String user_id=client.getHandshakeData().getSingleUrlParam("userid");
            UUID sessionId = client.getSessionId();
            redisUtils.set(user_id,sessionId);
            log.info(user_id+"连接成功"+redisUtils.get(user_id));
        }else{
            log.info("客户端为空");
        }

    }
    @OnDisconnect
    public void onDisConnect(SocketIOClient client){
        if(client!=null){
            String userid = client.getHandshakeData().getSingleUrlParam("userid");
            redisUtils.remove(userid);
            client.disconnect();
            log.info("用户连接断开");
        }else{
            log.info("客户端为空");
        }
    }
    @OnEvent(value = Event.JOIN)
    public void join(SocketIOClient client ,AckRequest request, JoinRequest data){
        log.info("用户"+data.getUserId()+"加入房间"+data.getGroupId());
        client.joinRoom(data.getGroupId());
        server.getRoomOperations(data.getGroupId()).sendEvent(Event.JOIN,data);
    }
    @OnEvent(value = Event.CHAT)
    public void chat(SocketIOClient client){

    }
    @OnEvent(value = Event.GROUP)
    public void group(SocketIOClient client, AckRequest request, GroupMsg data){
        log.info(data.getGroupId());
        server.getRoomOperations(data.getGroupId()).sendEvent(Event.GROUP,data);

    }
}
