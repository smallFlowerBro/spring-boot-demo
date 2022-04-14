package com.wei.shiro.db.service;

import com.wei.shiro.db.entity.UserEntity;
import com.wei.shiro.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity findByName(String userName){return userRepository.findByName(userName);}
}
