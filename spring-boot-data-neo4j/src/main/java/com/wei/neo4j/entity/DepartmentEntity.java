package com.wei.neo4j.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @Author weiyongjian
 * @Description //科室
 * @Date
 */
@NodeEntity(label="Department")
public class DepartmentEntity {
    @Id
    private long id;

    @Property(name = "name")
    private  String name;

    public DepartmentEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "{ id:"+this.id+",name:"+this.name+"}";
    }
}
