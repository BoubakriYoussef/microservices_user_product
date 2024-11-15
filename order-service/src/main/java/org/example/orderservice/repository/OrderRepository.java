package org.example.orderservice.repository;

import org.example.orderservice.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    // JpaRepository offre déjà les méthodes CRUD par défaut
}
