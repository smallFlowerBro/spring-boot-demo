package com.wei.log4j2;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@Log4j2
class SpringBootLogLog4j2ApplicationTests {

    @Test
    void contextLoads() {
        System.setProperty("log.dir","ZZJ01");
        log.error("dit it again!");
    }

}
