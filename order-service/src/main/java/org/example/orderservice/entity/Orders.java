package org.example.orderservice.entity;

import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-incrémenté
    private Long id;
    private String product; // Produit commandé
    private Double price;   // Prix de la commande

    private Long userId;    // ID de l'utilisateur associé à cette commande

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
