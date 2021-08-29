package com.wei.neo4j.repository;

import com.wei.neo4j.entity.ManagerEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends Neo4jRepository<ManagerEntity,Long> {
}
