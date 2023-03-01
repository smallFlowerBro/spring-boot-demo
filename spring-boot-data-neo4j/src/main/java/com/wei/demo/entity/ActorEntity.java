package com.wei.demo.entity;


import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/3/1 11:34
 ********************************/
@Node("actor")
@Data
public class ActorEntity {
    @Id
    @GeneratedValue
    private Long id;
    private  final String name;

    @Property("tagline")
    private final String description;

    public ActorEntity( String name, String description) {
        this.id = null;
        this.name = name;
        this.description = description;
    }
}
