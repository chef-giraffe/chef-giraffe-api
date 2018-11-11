package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.controllers.models.Table;
import com.chefgiraffe.api.repositories.RestaurantOrderRepository;
import com.chefgiraffe.api.repositories.RestaurantTableRepository;
import com.chefgiraffe.api.repositories.models.RestaurantOrder;
import com.chefgiraffe.api.repositories.models.RestaurantTable;
import com.chefgiraffe.api.services.RestaurantTableService;
import com.chefgiraffe.api.services.models.CreatedTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class TableController {
    private RestaurantTableRepository restaurantTableRepository;
    private RestaurantOrderRepository restaurantOrderRepository;
    private RestaurantTableService restaurantTableService;
    @Value("${base_url}")
    private String base_url;


    @Autowired
    public TableController(RestaurantTableService restaurantTableService, RestaurantTableRepository restaurantTableRepository, RestaurantOrderRepository restaurantOrderRepository) {
        this.restaurantTableService = restaurantTableService;
        this.restaurantOrderRepository = restaurantOrderRepository;
        this.restaurantTableRepository = restaurantTableRepository;
    }

    @GetMapping("/tables")
    public ResponseEntity<List<RestaurantTable>> getAllTables() {
        List<RestaurantTable> restaurantTables = new ArrayList<>();
        restaurantTableRepository.findAll().forEach(restaurantTables::add);
        return new ResponseEntity<>(restaurantTables, HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/table")
    public ResponseEntity<Object> createTable(@RequestBody Table table) {
        Optional<CreatedTable> createdTable = restaurantTableService.create(table.getRestaurantId(), table.getFriendlyName(), table.getAvailableSeats());
        if (createdTable.isPresent()) {
            UriComponents builder = UriComponentsBuilder.fromUriString(base_url)
                    .pathSegment("v1", "table", createdTable.get().getTableId().toString()).build(true);
            return ResponseEntity.created(builder.toUri()).build();
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/table/{id}")
    public ResponseEntity<Object> getTable(@PathVariable("id") UUID id) {
        Optional<RestaurantTable> table = restaurantTableRepository.findById(id);
        return table.map(restaurantTable1 -> new ResponseEntity<Object>(restaurantTable1, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/table/{id}/orders")
    public ResponseEntity<List<RestaurantOrder>> getOrdersForTable(@PathVariable("id") UUID id) {
        List<RestaurantOrder> restaurantOrders = new ArrayList<>();
        restaurantOrderRepository.findAll().forEach(restaurantOrders::add);
        return new ResponseEntity<>(restaurantOrders, HttpStatus.NOT_IMPLEMENTED);
    }
}
