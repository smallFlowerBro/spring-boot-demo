package com.wei.demo.primary.entity;

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
public class PrimaryTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "name")
    private  String name;

}
