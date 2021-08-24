package com.wei.jpa;

import com.wei.jpa.entity.StudentEntity;
import com.wei.jpa.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootOrmJpaApplicationTests {

    @Test
    void contextLoads(@Autowired StudentRepository studentRepository) {

        List<StudentEntity> all = studentRepository.findAll();
        for (StudentEntity studentEntity : all) {
            System.out.println(studentEntity);
        }

    }

}
