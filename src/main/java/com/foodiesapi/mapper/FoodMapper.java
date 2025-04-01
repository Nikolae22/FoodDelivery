package com.foodiesapi.mapper;

import com.foodiesapi.entity.FoodEntity;
import com.foodiesapi.io.FoodRequest;
import com.foodiesapi.io.FoodResponse;

public class FoodMapper {

    public static FoodEntity convertToEntity(FoodRequest foodRequest){
       // FoodEntity foodEntity=new FoodEntity();
       return FoodEntity.builder()
                .name(foodRequest.getName())
                .description(foodRequest.getDescription())
                .category(foodRequest.getCategory())
                .price(foodRequest.getPrice())
                .build();
    }

    public static FoodResponse convertToResponse(FoodEntity foodEntity){
        return FoodResponse.builder()
                .id(foodEntity.getId())
                .name(foodEntity.getName())
                .description(foodEntity.getDescription())
                .price(foodEntity.getPrice())
                .imageUrl(foodEntity.getImageUrl())
                .build();
    }
}
