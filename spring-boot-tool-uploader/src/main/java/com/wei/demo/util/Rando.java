package com.wei.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author weiyongjian
 * @Description 主键id生成器
 * @Date
 */
public class Rando {

    /**
     * 生成文件id
     * @return
     */
    public  static  String getFileID(){
        String id;
        String prefix_date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        int i = new Random().nextInt(3);
        return prefix_date+i;
    }

}
