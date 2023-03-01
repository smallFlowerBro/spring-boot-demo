package com.wei.demo.db.entity;

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
@Table(name = "config")
@Data
public class ConfigEntity {
    @Id
    private String name;

    @Column(name = "value")
    private String value;
}
