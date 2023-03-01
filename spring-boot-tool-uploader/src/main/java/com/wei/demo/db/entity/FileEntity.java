package com.wei.demo.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
