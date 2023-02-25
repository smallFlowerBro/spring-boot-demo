package com.wei.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Entity
@Table(name = "student")
@Data
public class StudentEntity {

    @Id
    private String id;

    @Column
    private String name;
    @Column
    private int age;
    @Column
    private int sex;
    @Column
    private String birthday;

}
