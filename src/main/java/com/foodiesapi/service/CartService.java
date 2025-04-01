package com.foodiesapi.service;

import com.foodiesapi.io.CardRequest;
import com.foodiesapi.io.CardResponse;

public interface CartService {

    CardResponse addToCart(CardRequest request);

    CardResponse getCart();

    void clearCart();
}
