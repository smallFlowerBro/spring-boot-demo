package com.wei.neo4j.entity;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RelationshipEntity(type = "manage")
@Data
public class ManagerEntity {
    @Id
    private long id;


    @StartNode
    private  DepartmentEntity parent;
    @EndNode
    private  DepartmentEntity child;

    public ManagerEntity(DepartmentEntity parent, DepartmentEntity child) {
        this.parent = parent;
        this.child = child;
    }

    public ManagerEntity(long id, DepartmentEntity parent, DepartmentEntity child) {
        this.id = id;
        this.parent = parent;
        this.child = child;
    }
}
