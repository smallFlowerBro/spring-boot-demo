package com.wei.neo4j.entity;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@NodeEntity(label = "Employee")
@Data
public class EmployeeEntity {
    @Id
    private long id;
    /*姓名*/
    @Property(name="name")
    private String name;
    /*年龄*/
    @Property(name="age")
    private Integer age;

    public EmployeeEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public EmployeeEntity(long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
