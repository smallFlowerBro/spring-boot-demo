package com.wei.jpa.repository;

import com.wei.jpa.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {
    @Override
    List<StudentEntity> findAll();
}
