package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.controllers.models.Order;
import com.chefgiraffe.api.services.RestaurantOrderService;
import com.chefgiraffe.api.services.models.CreatedOrder;
import com.chefgiraffe.api.services.models.OrderCreate;
import com.chefgiraffe.api.services.models.OrderInfo;
import com.chefgiraffe.api.services.models.OrderLookup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;
import java.util.UUID;

@RestController
public class OrderController {

    private static Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final RestaurantOrderService restaurantOrderService;
    private final String baseUrl;

    @Autowired
    public OrderController(RestaurantOrderService restaurantOrderService, @Value("${base_url}") String baseUrl) {
        this.restaurantOrderService = restaurantOrderService;
        this.baseUrl = baseUrl;
    }

    @GetMapping("/order")
    public ResponseEntity<?> readAll() {

        return ResponseEntity.ok(restaurantOrderService.retrieveAll());
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<?> readOne(@PathVariable("id") String id) {

        Optional<OrderInfo> retrieved = restaurantOrderService.retrieve(new OrderLookup(UUID.fromString(id)));
        if (retrieved.isPresent()) {

            logger.info("found order {}", retrieved.get().getOrderId());
            return ResponseEntity.ok(retrieved);
        } else {

            logger.warn("order {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/order")
    public ResponseEntity<?> create(@RequestBody Order order) {

        OrderCreate orderRequest = new OrderCreate(order.getTableId(), order.getOrderItems());

        Optional<CreatedOrder> createdOrder = restaurantOrderService.create(orderRequest);
        if (createdOrder.isPresent()) {

            logger.info("order {} created for table {}", createdOrder.get().getOrderId(), createdOrder.get().getTableId());
            UriComponents builder = UriComponentsBuilder.fromUriString(baseUrl)
                    .pathSegment("v1", "order", "{id}")
                    .buildAndExpand(createdOrder.get().getOrderId());

            return ResponseEntity.created(builder.toUri()).build();
        } else {

            logger.warn("order not created for table {}", order.getTableId());
            return ResponseEntity.badRequest().build();
        }
    }


}
