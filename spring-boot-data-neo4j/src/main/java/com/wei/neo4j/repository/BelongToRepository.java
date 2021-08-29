package com.wei.neo4j.repository;

import com.wei.neo4j.entity.BelongToShipEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BelongToRepository extends Neo4jRepository<BelongToShipEntity,Long> {
}
