package com.wei.multidatasource.primary.service;

import com.wei.multidatasource.primary.entity.PrimaryTestEntity;
import com.wei.multidatasource.primary.mapper.PrimaryTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Service
public class PrimaryTestService {

    @Autowired
    private PrimaryTestMapper primaryTestMapper;


    public List<PrimaryTestEntity> findAll(){
        return primaryTestMapper.findAll();
    }

}
