package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.MyEntity;
@Repository
public interface MyEntityRepo extends JpaRepository<MyEntity, Integer> {

}
