package com.wei.shiro.db.repository;

import com.wei.shiro.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
    @Query(value = "select * from user where u_name=?1",nativeQuery = true)
    UserEntity findByName(String userName);
}
