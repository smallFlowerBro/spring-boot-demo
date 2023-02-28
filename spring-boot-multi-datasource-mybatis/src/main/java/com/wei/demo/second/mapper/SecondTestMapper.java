package com.wei.demo.second.mapper;

import com.wei.demo.second.entity.SecondTestEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Mapper
public interface SecondTestMapper {
    List<SecondTestEntity> findAll();
}
