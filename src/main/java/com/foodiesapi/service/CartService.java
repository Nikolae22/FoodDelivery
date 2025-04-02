package com.foodiesapi.service;

import com.foodiesapi.io.CartRequest;
import com.foodiesapi.io.CartResponse;

public interface CartService {

    CartResponse addToCart(CartRequest request);

    CartResponse getCart();

    void clearCart();


}
