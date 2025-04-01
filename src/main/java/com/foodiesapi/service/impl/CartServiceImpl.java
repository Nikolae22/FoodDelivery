package com.foodiesapi.service.impl;

import com.foodiesapi.entity.CartEntity;
import com.foodiesapi.entity.ItemEntity;
import com.foodiesapi.io.CardRequest;
import com.foodiesapi.io.CardResponse;
import com.foodiesapi.repository.CartRepository;
import com.foodiesapi.service.CartService;
import com.foodiesapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserService userService;


    // Aggiungi un articolo al carrello
    @Override
    public CardResponse addToCart(CardRequest request) {
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
    public CardResponse getCart() {
        return null;
    }

    @Override
    public void clearCart() {

    }

    private CardResponse convertToResponse(CartEntity cartEntity) {
        return CardResponse.builder()
                .id(String.valueOf(cartEntity.getId()))
                .userId(cartEntity.getUserId())
                .items(cartEntity.getItems())
                .build();
    }
}
