package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.controllers.models.Table;
import com.chefgiraffe.api.services.RestaurantTableService;
import com.chefgiraffe.api.services.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;
import java.util.UUID;

@RestController
public class TableController {

    private static Logger logger = LoggerFactory.getLogger(TableController.class);

    private final RestaurantTableService restaurantTableService;
    private final String baseUrl;

    @Autowired
    public TableController(RestaurantTableService restaurantTableService,
                           @Value("baseUrl") String baseUrl) {
        this.restaurantTableService = restaurantTableService;
        this.baseUrl = baseUrl;
    }

    @GetMapping("/tables")
    public ResponseEntity<?> retrieveAll() {
        return ResponseEntity.ok(restaurantTableService.retrieveAll());
    }

    @GetMapping("/tables/{id}")
    public ResponseEntity<?> retrieve(@PathVariable("id") UUID id) {

        Optional<TableInfo> table = restaurantTableService.retrieve(new TableLookup(id));
        if (table.isPresent()) {

            logger.info("found table {} in restaurant {}", table.get().getId().toString(),
                    table.get().getRestaurantId().toString());
            return ResponseEntity.ok(table.get());
        } else {
            logger.warn("table {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tables/{id}/orders")
    public ResponseEntity<?> readOrders(@PathVariable("id") UUID id) {

        Optional<TableOrderDetails> orderDetails =
                restaurantTableService.retrieveAllOrders(new TableLookup(id));
        if (orderDetails.isPresent()) {

            logger.info("found order details for table {}", orderDetails.get().getId());
            return ResponseEntity.ok(orderDetails.get());
        } else {
            logger.warn("table {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/tables/{id}/orders/preparing")
    public ResponseEntity<?> readPreparingOrders(@PathVariable("id") UUID id) {

        Optional<TableOrderDetails> orderDetails =
                restaurantTableService.retrieveSpecificOrders(new TableLookup(id, OrderStatus.PREPARING));
        if (orderDetails.isPresent()) {

            logger.info("found preparing order details for table {}", orderDetails.get().getId());
            return ResponseEntity.ok(orderDetails.get());
        } else {
            logger.warn("table {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/tables")
    public ResponseEntity<?> create(@RequestBody Table table) {

        Optional<CreatedTable> createdTable =
                restaurantTableService.create(new TableCreate(table.getRestaurantId(),
                                                              table.getFriendlyName(),
                                                              table.getAvailableSeats()));
        if (createdTable.isPresent()) {

            UriComponents builder = UriComponentsBuilder.fromUriString(baseUrl)
                    .pathSegment("v1", "table", "{id}")
                    .buildAndExpand(createdTable.get().getId().toString());

            return ResponseEntity.created(builder.toUri()).build();
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
