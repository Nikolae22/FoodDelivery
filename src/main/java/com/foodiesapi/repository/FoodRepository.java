package com.foodiesapi.repository;

import com.foodiesapi.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity,String> {
}
