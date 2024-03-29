package com.wei.demo;

import com.wei.demo.entity.StudentEntity;
import com.wei.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootOrmMybatisApplicationTests {

    @Test
    void contextLoads(@Autowired StudentService studentService) {
        List<StudentEntity> all = studentService.findAll();
        for (StudentEntity studentEntity : all) {
            System.out.println(studentEntity);
        }

    }

}
