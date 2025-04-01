package com.foodiesapi.mapper;

import com.foodiesapi.entity.UserEntity;
import com.foodiesapi.io.UserRequest;
import com.foodiesapi.io.UserResponse;

public class UserMapper {

    public static UserEntity mapToUserEntity(UserRequest userRequest){
        return UserEntity.builder()
                .email(userRequest.getEmail())
                .name(userRequest.getName())
                .id(userRequest.getPassword())
                .build();
    }


//    public static UserEntity mapEntity(UserRequest userRequest,UserEntity userEntity){
//        userEntity.setEmail(userRequest.getEmail());
//        userEntity.setName(userRequest.getName());
//        userEntity.setPassword(userRequest.getPassword());
//       return  userEntity;
//    }

    public static UserResponse mapToResponse(UserEntity userEntity){
        return UserResponse.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .build();
    }

}
