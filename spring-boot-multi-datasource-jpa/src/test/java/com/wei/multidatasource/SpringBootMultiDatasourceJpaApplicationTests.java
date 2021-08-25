package com.wei.multidatasource;

import com.wei.multidatasource.primary.entity.PrimaryTestEntity;
import com.wei.multidatasource.primary.repository.PrimaryTestRepository;
import com.wei.multidatasource.second.entity.SecondTestEntity;
import com.wei.multidatasource.second.repository.SecondTestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMultiDatasourceJpaApplicationTests {

    @Test
    void contextLoads(@Autowired PrimaryTestRepository primaryTestRepository,
                      @Autowired SecondTestRepository secondTestRepository) {
        List<PrimaryTestEntity> all = primaryTestRepository.findAll();
        System.out.println("数据库一");
        for (PrimaryTestEntity testEntity : all) {
            System.out.println(testEntity);
        }

        System.out.println("数据库二");
        List<SecondTestEntity> all1 = secondTestRepository.findAll();
        for (SecondTestEntity secondTestEntity : all1) {
            System.out.println(secondTestEntity);
        }

    }

}
