package com.restaurent.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurent.microservice.entity.FoodMenu;

@Repository
public interface FoodMenuRepository extends JpaRepository<FoodMenu, Long>{

}
