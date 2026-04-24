package com.wei.demo;

import com.wei.demo.entity.UserEntity;
import com.wei.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootSecurityApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 创建一个初始用户
        if (userRepository.findByUsername("admin") == null) {
            UserEntity user = new UserEntity("admin", passwordEncoder.encode("password"), "ROLE_USER");
            userRepository.save(user);
        }
    }
}
