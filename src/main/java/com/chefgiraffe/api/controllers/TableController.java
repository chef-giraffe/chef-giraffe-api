package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.repositories.OrderRepository;
import com.chefgiraffe.api.repositories.TableRepository;
import com.chefgiraffe.api.repositories.models.RestaurantOrder;
import com.chefgiraffe.api.repositories.models.RestaurantTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class TableController {
    TableRepository tableRepository;
    OrderRepository orderRepository;

    @Autowired
    public TableController(TableRepository tableRepository, OrderRepository orderRepository) {
        this.tableRepository = tableRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/tables")
    public ResponseEntity<List<RestaurantTable>> getAllTables() {
        List<RestaurantTable> restaurantTables = new ArrayList<>();
        tableRepository.findAll().forEach(restaurantTables::add);
        return new ResponseEntity<>(restaurantTables, HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/table/{id}")
    public ResponseEntity<Object> getTable(@PathVariable("id") UUID id) {
        Optional<RestaurantTable> table = tableRepository.findById(id);
        return table.map(restaurantTable1 -> new ResponseEntity<Object>(restaurantTable1, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/table/{id}/orders")
    public ResponseEntity<List<RestaurantOrder>> getOrdersForTable(@PathVariable("id") UUID id) {
        List<RestaurantOrder> restaurantOrders = new ArrayList<>();
        orderRepository.findAll().forEach(restaurantOrders::add);
        return new ResponseEntity<>(restaurantOrders, HttpStatus.NOT_IMPLEMENTED);
    }
}
