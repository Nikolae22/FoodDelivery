package com.foodiesapi.service.impl;

import com.foodiesapi.entity.UserEntity;
import com.foodiesapi.io.UserRequest;
import com.foodiesapi.io.UserResponse;
import com.foodiesapi.mapper.UserMapper;
import com.foodiesapi.repository.UserRepository;
import com.foodiesapi.service.AuthenticationFacade;
import com.foodiesapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationFacade authenticationFacade;


    @Override
    public UserResponse registerUser(UserRequest request) {
        UserEntity newUser = UserMapper.mapToUserEntity(request);
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser = userRepository.save(newUser);

        return UserMapper.mapToResponse(newUser);
    }

    @Override
    public String findByUserId() {
        String loggedInUserEmail = authenticationFacade.getAuthentication().getName();
       UserEntity loggedInUser= userRepository.findByEmail(loggedInUserEmail)
                .orElseThrow(() -> new RuntimeException("Email not found"));
       return loggedInUser.getId();
    }

}
