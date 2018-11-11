package com.chefgiraffe.api.controllers;

import com.chefgiraffe.api.controllers.models.Table;
import com.chefgiraffe.api.repositories.models.RestaurantOrder;
import com.chefgiraffe.api.repositories.models.RestaurantTable;
import com.chefgiraffe.api.services.RestaurantTableService;
import com.chefgiraffe.api.services.models.CreatedTable;
import com.chefgiraffe.api.services.models.TableCreate;
import com.chefgiraffe.api.services.models.TableInfo;
import com.chefgiraffe.api.services.models.TableLookup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @GetMapping("/table/{id}")
    public ResponseEntity<?> retrieve(@PathVariable("id") String id) {

        Optional<TableInfo> table = restaurantTableService.retrieve(new TableLookup(UUID.fromString(id)));
        if (table.isPresent()) {

            logger.info("found table {} in restaurant {}", table.get().getTableId().toString(),
                    table.get().getRestaurantId().toString());
            return ResponseEntity.ok(table.get());
        } else {
            logger.warn("table {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/table")
    public ResponseEntity<Object> create(@RequestBody Table table) {

        Optional<CreatedTable> createdTable =
                restaurantTableService.create(new TableCreate(table.getRestaurantId(),
                                                              table.getFriendlyName(),
                                                              table.getAvailableSeats()));
        if (createdTable.isPresent()) {

            UriComponents builder = UriComponentsBuilder.fromUriString(baseUrl)
                    .pathSegment("v1", "table", "{id}")
                    .buildAndExpand(createdTable.get().getTableId().toString());

            return ResponseEntity.created(builder.toUri()).build();
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }
}
