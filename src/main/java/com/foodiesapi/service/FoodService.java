package com.foodiesapi.service;

import com.foodiesapi.io.FoodRequest;
import com.foodiesapi.io.FoodResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface FoodService {

  String uploadFile(MultipartFile file);
  FoodResponse addFood(FoodRequest request, MultipartFile file);

  List<FoodResponse> readFoods();

 FoodResponse readFood(String id);

 boolean deleteFile(String fileName);

 void deleteFood(String id);
}
