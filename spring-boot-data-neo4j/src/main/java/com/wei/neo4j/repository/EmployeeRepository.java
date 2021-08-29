package com.wei.neo4j.repository;

import com.wei.neo4j.entity.EmployeeEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author weiyongjian
 * @Description //TODO
 * @Date
 */
@Repository
public interface EmployeeRepository  extends Neo4jRepository<EmployeeEntity,Long> {
}
