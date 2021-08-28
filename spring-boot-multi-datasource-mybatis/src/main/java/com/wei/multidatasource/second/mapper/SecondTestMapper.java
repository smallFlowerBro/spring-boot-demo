package com.wei.multidatasource.second.mapper;

import com.wei.multidatasource.primary.entity.PrimaryTestEntity;
import com.wei.multidatasource.second.entity.SecondTestEntity;
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
