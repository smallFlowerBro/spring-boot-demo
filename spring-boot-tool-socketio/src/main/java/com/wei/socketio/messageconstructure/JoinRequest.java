package com.wei.socketio.messageconstructure;

import lombok.Data;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Data
public class JoinRequest {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 群名称
     */
    private String groupId;
}
