package com.wei.socketio.messageconstructure;

import lombok.Data;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Data
public class GroupMsg {
    private String userId;
    private String groupId;
    private String msg;
}
