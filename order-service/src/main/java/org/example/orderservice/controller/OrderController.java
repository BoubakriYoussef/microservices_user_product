package org.example.orderservice.controller;

import org.example.orderservice.DTO.UserDTO;
import org.example.orderservice.client.UserClient;
import org.example.orderservice.entity.Orders;
import org.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders") // Base de l'URL pour les endpoints
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    UserClient userClient;

    // Endpoint pour créer une commande
    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order) {
        UserDTO user = userClient.getUserById(order.getUserId());

        if(user!=null) {
            order.setUserId(user.getId());
            orderRepository.save(order);
            return new ResponseEntity<>(order, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour récupérer toutes les commandes
    @GetMapping
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    // Endpoint pour récupérer une commande par ID
    @GetMapping("/{id}")
    public Orders getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
