package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.repositories.OrderRepository;
import com.chefgiraffe.api.repositories.TableRepository;
import com.chefgiraffe.api.repositories.models.Order;
import com.chefgiraffe.api.repositories.models.Table;
import org.hibernate.sql.ordering.antlr.OrderByAliasResolver;
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
    public ResponseEntity<List<Table>> getAllTables() {
        List<Table> tables = new ArrayList<>();
        tableRepository.findAll().forEach(tables::add);
        return new ResponseEntity<>(tables, HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/table/{id}")
    public ResponseEntity<Object> getTable(@PathVariable("id") UUID id) {
        Optional<Table> table = tableRepository.findById(id);
        return table.map(table1 -> new ResponseEntity<Object>(table1, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/table/{id}/orders")
    public ResponseEntity<List<Order>> getOrdersForTable(@PathVariable("id") UUID id) {
        List<Order> orders = new ArrayList<>();
        orderRepository.findAll().forEach(orders::add);
        return new ResponseEntity<>(orders, HttpStatus.NOT_IMPLEMENTED);
    }
}
