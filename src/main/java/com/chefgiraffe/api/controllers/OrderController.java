package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.controllers.models.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class OrderController {

    @GetMapping("/order/{id}")
    public Order getOrder(String id) {
        return null;
    }

    @GetMapping("/order/active")
    public List<Order> activeOrders() {
        return null;
    }

    @PostMapping("/order")
    public ResponseEntity<Object> createId(Order order) {
        com.chefgiraffe.api.repository.models.Order orderObject = new com.chefgiraffe.api.repository.models.Order();
        UriComponents builder = UriComponentsBuilder.fromUriString("")
                .pathSegment("v1", "order", orderObject.getId().toString()).build(true);
        return ResponseEntity.created(builder.toUri()).build();
    }
}
