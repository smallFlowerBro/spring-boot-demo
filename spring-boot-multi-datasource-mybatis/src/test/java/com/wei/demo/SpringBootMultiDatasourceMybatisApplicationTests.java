package com.wei.demo;

import com.wei.demo.primary.entity.PrimaryTestEntity;
import com.wei.demo.primary.service.PrimaryTestService;
import com.wei.demo.second.entity.SecondTestEntity;
import com.wei.demo.second.service.SecondTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMultiDatasourceMybatisApplicationTests {

    @Test
    void contextLoads(@Autowired PrimaryTestService primaryTestService,
            @Autowired SecondTestService secondDataSource
    ) {
        List<PrimaryTestEntity> all = primaryTestService.findAll();
        for (PrimaryTestEntity primaryTestEntity : all) {
            System.out.println(primaryTestEntity);
        }

        List<SecondTestEntity> all1 = secondDataSource.findAll();
        for (SecondTestEntity secondr : all1) {
            System.out.println(secondr);
        }


    }

}
