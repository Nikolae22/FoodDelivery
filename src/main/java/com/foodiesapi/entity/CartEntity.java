package com.foodiesapi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@Entity(name = "cards")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ID del carrello

    @Column(name = "user_id", nullable = false)
    private String userId;  // ID dell'utente associato al carrello

    // Relazione One-to-Many con ItemEntity
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEntity> items;

    // Costruttore per JPA
    public CartEntity() {}

    // Costruttore che accetta userId e una lista di articoli
    public CartEntity(String userId, List<ItemEntity> items) {
        this.userId = userId;
        this.items = items;
    }

//    @Id
//    private String id;
//    private String userId;
//    private String items;
//
//    public CartEntity(String userId, List<?> items) {
//        this.userId=userId;
//        this.items= items.toString();
//    }
//
//    // Usa @ElementCollection per mappare una mappa
//    @ElementCollection
//    @MapKeyColumn(name = "item_key") // Nome della colonna per la chiave
//    @Column(name = "item_value") // Nome della colonna per il valore
//    private Map<String,Integer> items =new HashMap<>();
//
//    public CartEntity(String userId,Map<String,Integer> items){
//        this.userId=userId;
//        this.items=items;
//    }



}
