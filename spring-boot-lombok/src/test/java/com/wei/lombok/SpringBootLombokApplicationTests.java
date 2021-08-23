package com.wei.lombok;

import com.wei.lombok.entity.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootLombokApplicationTests {

    @Test
    void contextLoads() {
        StudentEntity student = StudentEntity.builder()
                .name("小花")
                .age(21)
                .sex("男").build();
        System.out.println(student.toString());
    }

}
