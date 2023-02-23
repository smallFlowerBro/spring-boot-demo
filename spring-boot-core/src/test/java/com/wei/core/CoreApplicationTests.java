package com.wei.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.Assert;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

/*@SpringBootTest*/
class CoreApplicationTests {
   @Test
   public static void  test1(){
       String name = null;
       Assert.notNull(name,"name can not be null");
   }
   @Test
    public void test2(){
       CoreApplicationTests.test1();
   }
}
