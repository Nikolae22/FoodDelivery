package com.foodiesapi.service.impl;

import com.foodiesapi.service.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AuthenticationFacadeImpl implements AuthenticationFacade {


    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
