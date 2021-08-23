package com.wei.lombok.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @Author weiyongjian
 * @Description lombok 使用
 * @Date
 */
@Data
@Builder
public class StudentEntity {
    /*姓名*/
    private String name;
    /*年龄*/
    private int age;
    /*性别*/
    private String sex;
}
