package com.wei.demo.relationship;

import com.wei.demo.entity.ActorEntity;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/3/1 11:35
 ********************************/
@RelationshipProperties
public class RoleRelationship {

    @Id
    @GeneratedValue
    private Long id;
    private final String name;

    @TargetNode
    private ActorEntity actorEntity;

    public RoleRelationship(String name, ActorEntity actorEntity) {
        this.id = null;
        this.name = name;
        this.actorEntity = actorEntity;
    }


}
