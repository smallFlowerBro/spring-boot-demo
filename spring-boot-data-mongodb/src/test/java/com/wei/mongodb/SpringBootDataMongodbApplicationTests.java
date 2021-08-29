package com.wei.mongodb;

import com.wei.mongodb.entity.UserEntity;
import com.wei.mongodb.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDataMongodbApplicationTests {

    @Test
    void contextLoads(@Autowired UserRepository userRe) {

        UserEntity user = new UserEntity();
        user.setId("0001");
        user.setUserName("xiaohua");
        userRe.save(user);
        user.setId("0001");
        user.setUserName("xiaohua1");
        userRe.save(user);
        System.out.println(userRe.findById("0001").get().getUserName());

    }

}
