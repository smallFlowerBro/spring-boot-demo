package com.wei.demo.primary.repository;

import com.wei.demo.primary.entity.PrimaryTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryTestRepository extends JpaRepository<PrimaryTestEntity,Integer> {

}
