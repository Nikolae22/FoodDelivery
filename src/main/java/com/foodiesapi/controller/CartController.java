package com.foodiesapi.controller;

import com.foodiesapi.io.CardRequest;
import com.foodiesapi.io.CardResponse;
import com.foodiesapi.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;


    @PostMapping("/add")
    public CardResponse addToCart(@RequestBody CardRequest request) {
        return cartService.addToCart(request);
    }


}
