package com.foodiesapi.service.impl;

import com.foodiesapi.entity.UserEntity;
import com.foodiesapi.io.UserRequest;
import com.foodiesapi.io.UserResponse;
import com.foodiesapi.mapper.UserMapper;
import com.foodiesapi.repository.UserRepository;
import com.foodiesapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserResponse registerUser(UserRequest request) {
        UserEntity newUser = UserMapper.mapToUserEntity(request);
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser = userRepository.save(newUser);

        return UserMapper.mapToResponse(newUser);
    }
}
