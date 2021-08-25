package com.wei.multidatasource.second.repository;

import com.wei.multidatasource.second.entity.SecondTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondTestRepository extends JpaRepository<SecondTestEntity,Integer> {

}
