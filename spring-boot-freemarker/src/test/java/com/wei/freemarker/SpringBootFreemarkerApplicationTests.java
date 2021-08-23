package com.wei.freemarker;

import com.wei.freemarker.util.FreemarkerUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBootFreemarkerApplicationTests {

    @Test
    void contextLoads(@Autowired FreemarkerUtil freemarkerUtil) {
        Map map = new HashMap<String,Object>();
        map.put("name","xiaohua");
        System.out.println(freemarkerUtil.process("user.xml",map));

    }

}
