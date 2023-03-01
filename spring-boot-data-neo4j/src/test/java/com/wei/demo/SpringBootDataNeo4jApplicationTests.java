package com.wei.demo;

import com.wei.demo.entity.ActorEntity;
import com.wei.demo.entity.MovieEntity;
import com.wei.demo.relationship.RoleRelationship;
import com.wei.demo.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootDataNeo4jApplicationTests {

    @Autowired
    private MovieRepository movieRepository;
    @Test
    void contextLoads() {
        MovieEntity movieEntity = new MovieEntity("肖申克的救赎", "自我救赎,重获自由");
        movieEntity.addActor(new RoleRelationship("安迪",new ActorEntity("Tim","美国")))
                .addActor(new RoleRelationship("路德",new ActorEntity("Morgan","美国")));
        movieRepository.save(movieEntity);
    }

}
