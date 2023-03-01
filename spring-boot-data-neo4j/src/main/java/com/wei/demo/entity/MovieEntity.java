
/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/2/26 23:20
 ********************************/
package com.wei.demo.entity;

import com.wei.demo.relationship.RoleRelationship;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@Node("movie")
@Data
public class MovieEntity {
    @Id
    @GeneratedValue
    private Long id;

    private final String title;

    @Property("tagline")
    private final String description;

    @Relationship(type = "ACTED_IN",direction = Relationship.Direction.INCOMING)
    private List<RoleRelationship> actors;

    public MovieEntity( String title, String description) {
        this.id = null;
        this.title = title;
        this.description = description;
    }

    public MovieEntity withId(Long id){
        if(id.equals(this.id)){
            return this;
        }else{
            MovieEntity movieEntity = new MovieEntity(this.title, this.description);
            movieEntity.id=id;
            return movieEntity;
        }
    }

    public MovieEntity addActor(RoleRelationship roleRelationship){
        if(actors==null){
            actors = new ArrayList<RoleRelationship>();
        }
        this.actors.add(roleRelationship);
        return  this;
    }

}


