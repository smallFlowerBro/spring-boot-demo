package com.wei.mongodb.service;

import com.wei.mongodb.entity.UserEntity;
import com.wei.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/2/26 10:58
 ********************************/
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity findById(String id){
        Optional<UserEntity> byId = userRepository.findById(id);
        return byId.get();
    }

    public UserEntity save(UserEntity userEntity){

        return userRepository.save(userEntity);


    }

}
