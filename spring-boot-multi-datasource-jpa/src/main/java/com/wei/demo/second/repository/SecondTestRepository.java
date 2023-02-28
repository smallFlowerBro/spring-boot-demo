package com.wei.demo.second.repository;

import com.wei.demo.second.entity.SecondTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondTestRepository extends JpaRepository<SecondTestEntity,Integer> {

}
