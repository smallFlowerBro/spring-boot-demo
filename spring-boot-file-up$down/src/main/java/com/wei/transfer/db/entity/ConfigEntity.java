package com.wei.transfer.db.entity;

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
@Table(name = "config")
@Data
public class ConfigEntity {
    @Id
    private String name;

    @Column(name = "value")
    private String value;
}
