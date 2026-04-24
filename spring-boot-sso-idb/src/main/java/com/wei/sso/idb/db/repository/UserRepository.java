package com.wei.sso.idb.db.repository;

import com.wei.sso.idb.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
public interface UserRepository extends JpaRepository<UserEntity,String> {

    @Query(value = "select * from  sso_user where user_name =?1 and password = ?2",nativeQuery = true)
    UserEntity findByUserNameAndPassword(String userName,String pwd);

}
