package com.wei.demo.db.repository;

import com.wei.demo.db.entity.ConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Repository
public interface ConfigRepository extends JpaRepository<ConfigEntity, String> {

    @Query(nativeQuery = true,value = "select name,value from config where name= ?1")
    public ConfigEntity findConfigByName(String name);

}
