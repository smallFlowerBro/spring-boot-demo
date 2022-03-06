package com.wei.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailApplicationTests {

    @Test
    void contextLoads(@Autowired  TextSender sender) {
       sender.send("测试","hello ,jushouqingtian",new String[]{"1262405508@qq.com"});
    }

}
