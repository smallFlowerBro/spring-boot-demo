package com.wei.multidatasource.primary.mapper;

import com.wei.multidatasource.primary.entity.PrimaryTestEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Mapper
public interface PrimaryTestMapper {
    List<PrimaryTestEntity> findAll();
}
