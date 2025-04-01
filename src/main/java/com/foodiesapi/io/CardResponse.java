package com.foodiesapi.io;

import com.foodiesapi.entity.CartEntity;
import com.foodiesapi.entity.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardResponse {

    private String id;
    private String userId;
    private List<ItemEntity> items;  // Lista di articoli nel carrello
}
