package com.wei.demo.mapper;

import com.wei.demo.entity.StudentEntity;
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
