package com.wei.demo.repository;

import com.wei.demo.entity.StudentEntity;
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
