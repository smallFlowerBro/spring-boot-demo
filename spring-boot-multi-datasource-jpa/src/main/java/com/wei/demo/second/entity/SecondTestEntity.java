package com.wei.demo.second.entity;

import jakarta.persistence.*;
import lombok.Data;



/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Entity
@Table(name="test")
@Data
public class SecondTestEntity {
    @Id
    @GeneratedValue
    private  Integer id;

    @Column(name = "name")
    private  String name;

}
