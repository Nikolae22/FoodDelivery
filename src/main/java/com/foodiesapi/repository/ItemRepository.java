package com.foodiesapi.repository;

import com.foodiesapi.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
}
