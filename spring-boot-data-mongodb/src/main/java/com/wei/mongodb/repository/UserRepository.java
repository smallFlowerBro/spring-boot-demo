package com.wei.mongodb.repository;

import com.wei.mongodb.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Repository
public interface UserRepository extends MongoRepository<UserEntity,String> {
    @Override
    Optional<UserEntity> findById(String id);

}
