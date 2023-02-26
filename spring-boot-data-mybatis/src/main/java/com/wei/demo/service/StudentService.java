package com.wei.demo.service;

import com.wei.demo.entity.StudentEntity;
import com.wei.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<StudentEntity> findAll(){
        return studentMapper.findAll();
    }

}
