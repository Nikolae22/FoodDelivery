package com.foodiesapi.service.impl;

import com.foodiesapi.entity.CartEntity;
import com.foodiesapi.entity.ItemEntity;
import com.foodiesapi.io.CartRequest;
import com.foodiesapi.io.CartResponse;
import com.foodiesapi.repository.CartRepository;
import com.foodiesapi.service.CartService;
import com.foodiesapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserService userService;


    // Aggiungi un articolo al carrello
    @Override
    public CartResponse addToCart(CartRequest request) {
        String loggedInUserId = userService.findByUserId();
        // Trova il carrello dell'utente
        Optional<CartEntity> cartOptional = cartRepository.findByUserId(loggedInUserId);

        // Se non esiste un carrello, crealo
        CartEntity cartEntity = cartOptional.orElseGet(() -> new CartEntity(loggedInUserId, List.of()));

        // Crea un nuovo articolo
        ItemEntity itemEntity = new ItemEntity(cartEntity, request.getFoodId(), 1);  // Quantità iniziale 1

        // Aggiungi l'articolo alla lista di articoli del carrello
        cartEntity.getItems().add(itemEntity);

        // Salva il carrello e gli articoli
        cartEntity = cartRepository.save(cartEntity);  // I nuovi articoli verranno salvati automaticamente grazie alla cascata
        return convertToResponse(cartEntity);
    }

    @Override
    public CartResponse getCart() {
        String loggedInUserId = userService.findByUserId();
        CartEntity entity = cartRepository.findByUserId(loggedInUserId)
                .orElse(new CartEntity(null, loggedInUserId, new ArrayList<>()));
        return convertToResponse(entity);
    }

    @Override
    public void clearCart() {
        String loggedInUserId = userService.findByUserId();
        cartRepository.deleteByUserId(loggedInUserId);

    }


    private CartResponse convertToResponse(CartEntity cartEntity) {
        return CartResponse.builder()
                .id(String.valueOf(cartEntity.getId()))
                .userId(cartEntity.getUserId())
                .items(cartEntity.getItems())
                .build();
    }
}
