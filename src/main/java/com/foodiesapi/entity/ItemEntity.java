package com.foodiesapi.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ID dell'item

    @ManyToOne(fetch = FetchType.LAZY)  // Relazione Many-to-One con CartEntity
    @JoinColumn(name = "cart_id", nullable = false)
    private CartEntity cart;  // Il carrello a cui appartiene questo item

    @Column(name = "item_key", nullable = false)
    private String itemKey;  // Nome o ID dell'item (ad esempio, l'ID del cibo)

    @Column(name = "item_value", nullable = false)
    private Integer itemValue;  // Quantità dell'item nel carrello

    // Costruttore per JPA
    public ItemEntity() {}

    // Costruttore che accetta cart, itemKey e itemValue
    public ItemEntity(CartEntity cart, String itemKey, Integer itemValue) {
        this.cart = cart;
        this.itemKey = itemKey;
        this.itemValue = itemValue;
    }
}
