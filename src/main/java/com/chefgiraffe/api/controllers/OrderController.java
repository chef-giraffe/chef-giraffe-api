package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.controllers.models.Order;
import com.chefgiraffe.api.repositories.models.OrderStatus;
import com.chefgiraffe.api.repositories.models.RestaurantOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class OrderController {

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") String id) {
        return null;
    }

    @GetMapping("/order/active")
    public ResponseEntity<List<Order>> activeOrders() {
        return null;
    }

    @PostMapping("/order")
    public ResponseEntity<Object> createId(Order order) {
        RestaurantOrder restaurantOrderObject = new RestaurantOrder(order.getTableId(), OrderStatus.CREATED);
        UriComponents builder = UriComponentsBuilder.fromUriString("")
                .pathSegment("v1", "order", restaurantOrderObject.getId().toString()).build(true);
        return ResponseEntity.created(builder.toUri()).build();
    }


}
