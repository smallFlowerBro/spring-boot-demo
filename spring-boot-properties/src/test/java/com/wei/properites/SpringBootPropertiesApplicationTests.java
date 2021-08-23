package com.wei.properites;

import com.wei.properites.config.PropertiesOne;
import com.wei.properites.config.PropertiesTwo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootPropertiesApplicationTests {

    @Test
    void contextLoads(
            @Autowired PropertiesOne propertiesOne,
            @Autowired PropertiesTwo propertiesTwo
                    ) {
        System.out.println(propertiesOne);
        System.out.println(propertiesTwo);

    }

}
