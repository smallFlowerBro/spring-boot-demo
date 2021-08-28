package com.wei.multidatasource.second.service;

import com.wei.multidatasource.primary.entity.PrimaryTestEntity;
import com.wei.multidatasource.primary.mapper.PrimaryTestMapper;

import com.wei.multidatasource.second.entity.SecondTestEntity;
import com.wei.multidatasource.second.mapper.SecondTestMapper;
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
