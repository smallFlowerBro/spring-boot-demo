package com.wei.log4j2;




import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class SpringBootLogLog4j2ApplicationTests {
    @Test
    void contextLoads() {
//        System.setProperty("logPath","ZZJ01");
        //MDC.put("deviceNo","ZZJ01");
        log.error("测试");
    }

}
