package com.wei.demo.second.service;

import com.wei.demo.second.entity.SecondTestEntity;
import com.wei.demo.second.mapper.SecondTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Service
public class SecondTestService {

    @Autowired
    private SecondTestMapper secondTestMapper;


    public List<SecondTestEntity> findAll(){
        return secondTestMapper.findAll();
    }

}
