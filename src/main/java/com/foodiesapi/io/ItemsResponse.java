package com.foodiesapi.io;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemsResponse {

    private String itemKey;  // Nome o ID dell'articolo (cibo)
    private Integer itemValue;  // Quantità dell'articolo
}
