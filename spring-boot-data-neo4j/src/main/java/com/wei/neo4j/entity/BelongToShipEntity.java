package com.wei.neo4j.entity;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@RelationshipEntity(type = "BelongTo")
@Data
public class BelongToShipEntity {
    @Id
    private long id;

    @StartNode
    private  EmployeeEntity employeeEntity;

    @EndNode
    private  DepartmentEntity departmentEntity;

    public BelongToShipEntity(long id, EmployeeEntity employeeEntity, DepartmentEntity departmentEntity) {
        this.id = id;
        this.employeeEntity = employeeEntity;
        this.departmentEntity = departmentEntity;
    }

}
