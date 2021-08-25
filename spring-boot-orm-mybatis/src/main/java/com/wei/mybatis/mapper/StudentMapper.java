package com.wei.mybatis.mapper;

import com.wei.mybatis.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Mapper
public interface StudentMapper {

    List<StudentEntity> findAll();


}
