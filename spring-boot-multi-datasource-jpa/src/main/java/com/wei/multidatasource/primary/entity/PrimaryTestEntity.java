package com.wei.multidatasource.primary.entity;

import lombok.Data;

import javax.persistence.*;

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
