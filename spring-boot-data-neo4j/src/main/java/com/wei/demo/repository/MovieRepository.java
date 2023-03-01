package com.wei.demo.repository;

import com.wei.demo.entity.MovieEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/3/1 12:35
 ********************************/
public interface MovieRepository extends Neo4jRepository<MovieEntity,Long> {
}
