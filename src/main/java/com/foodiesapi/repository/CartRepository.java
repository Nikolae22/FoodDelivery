package com.foodiesapi.repository;

import com.foodiesapi.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<CartEntity,String> {

   Optional<CartEntity> findByUserId(String userId);

   void deleteByUserId(String userId);
}
