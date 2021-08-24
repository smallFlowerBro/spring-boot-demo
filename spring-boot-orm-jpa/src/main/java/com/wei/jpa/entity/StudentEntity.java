package com.wei.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
