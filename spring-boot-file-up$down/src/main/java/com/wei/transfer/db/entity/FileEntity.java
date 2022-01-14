package com.wei.transfer.db.entity;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(name = "file")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileEntity {

    @Id
    private  String file_id;

    @Column(name = "file_path")
    private String file_path;
}
