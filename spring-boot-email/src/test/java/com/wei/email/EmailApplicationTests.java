package com.wei.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

@SpringBootTest
class EmailApplicationTests {

    @Test
    void contextLoads(@Autowired  TextSender sender) {
       sender.send("测试","hello ,jushouqingtian",new String[]{"1262405508@qq.com"});
    }
    @Test
    void  test2(@Autowired  HtmlSender sender) {

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        HashMap<String, File> stringStringHashMap2 = new HashMap<>();
        stringStringHashMap.put("name","小花");
        HashMap<String, Resource> stringResourceHashMap = new HashMap<>();
        FileSystemResource fileSystemResource = new FileSystemResource("src/main/resources/img/test.png");
        File file = new File("src/main/resources/img/test.png");
        System.out.println(fileSystemResource.exists());

        stringResourceHashMap.put("avar",fileSystemResource);
        stringStringHashMap2.put("hello",file);
        sender.send(stringStringHashMap,"HelloWorld.html",new String[]{"1262405508@qq.com"},"测试",stringResourceHashMap,stringStringHashMap2);
    }

}
