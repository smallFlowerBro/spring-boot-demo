package com.wei.shiro.db.entity;

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
@Table(name = "user")
@Data
public class UserEntity {

    @Id
    @Column(name = "u_id")
    private String id;

    @Column(name = "u_name")
    private String username;

    @Column(name = "u_pwd")
    private String password;

    @Column(name = "u_roles")
    private String roles;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private int sex;

    @Column(name = "address")
    private String address;


}
