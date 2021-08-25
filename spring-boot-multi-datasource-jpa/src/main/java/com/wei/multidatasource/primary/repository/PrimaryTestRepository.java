package com.wei.multidatasource.primary.repository;

import com.wei.multidatasource.primary.entity.PrimaryTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryTestRepository extends JpaRepository<PrimaryTestEntity,Integer> {

}
