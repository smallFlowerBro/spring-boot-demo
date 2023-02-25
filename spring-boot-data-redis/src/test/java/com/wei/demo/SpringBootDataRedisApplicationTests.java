package com.wei.demo;

import com.wei.demo.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class SpringBootDataRedisApplicationTests {

    class NoteList{
        String name;
        int age;
        public NoteList(){}
        public NoteList(String name){this.name=name;}
    }
    @Test
    void contextLoads(@Autowired RedisUtil redisOP){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("XXXXXX");
        redisOP.set("xiaogua",strings);

        System.out.println(redisOP.get("xiaogua"));
    }

}
