package com.wei.demo.service;

import com.wei.demo.entity.StudentEntity;
import com.wei.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/2/26 0:57
 ********************************/
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> findAll(){
        return studentRepository.findAll();
    }
}
