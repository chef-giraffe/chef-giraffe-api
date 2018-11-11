package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.controllers.models.Order;
import com.chefgiraffe.api.services.OrderService;
import com.chefgiraffe.api.services.models.CreatedOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    private OrderService orderService;
    @Value("${base_url}")
    private String base_url;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") String id) {
        return null;
    }

    @GetMapping("/order/active")
    public ResponseEntity<List<Order>> activeOrders() {
        return null;
    }

    @PostMapping("/order")
    public ResponseEntity<Object> createId(@RequestBody Order order) {
        Optional<CreatedOrder> createdOrder = orderService.create(order.getTableId(), order.getOrderItems());

        if (createdOrder.isPresent()) {
            UriComponents builder = UriComponentsBuilder.fromUriString(base_url)
                    .pathSegment("v1", "order", createdOrder.get().getOrderId().toString()).build(true);
            return ResponseEntity.created(builder.toUri()).build();
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


}
