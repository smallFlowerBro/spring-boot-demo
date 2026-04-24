package com.wei.sso.idb.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author weiyongjian
 * @Description //sso_user表实体
 * @Date
 */

@Entity
@Table(name = "sso_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private String uid;

    @Column(name = "user_name")
    private String userName;

    @Column(name="password")
    private String password;
}
