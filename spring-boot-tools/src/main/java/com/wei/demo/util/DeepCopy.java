package com.wei.demo.util;

import java.io.*;

/*********************************
 *   @Author WEIYJ
 *   @Description 深拷贝
 *   @Data 2023/3/15 10:54
 ********************************/
public interface DeepCopy<T>  {

    default T cloneObject(){
        ByteArrayOutputStream boo = new ByteArrayOutputStream();
        ObjectOutputStream obt = null;
        Object o =null;
        try {
            obt = new ObjectOutputStream(boo);
            obt.writeObject(this);
            ObjectInputStream objectInputStream = new ObjectInputStream( new ByteArrayInputStream(boo.toByteArray()));
            o = objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) o;

    }
}
