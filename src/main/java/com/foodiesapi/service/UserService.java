package com.foodiesapi.service;

import com.foodiesapi.io.UserRequest;
import com.foodiesapi.io.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRequest request);
}
