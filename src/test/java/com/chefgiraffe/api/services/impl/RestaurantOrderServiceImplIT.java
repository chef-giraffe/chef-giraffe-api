package com.chefgiraffe.api.services.impl;

import com.chefgiraffe.api.services.OrderService;
import com.chefgiraffe.api.services.models.CreatedOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantOrderServiceImplIT {

    @Autowired
    private OrderService orderService;

    @Test
    public void createOrders() {

        UUID tableId = UUID.fromString("127e65d0-13a0-4be2-9b5a-ed0635b9c5ce");
        List<UUID> itemIds = Collections.singletonList(UUID.randomUUID());

        Optional<CreatedOrder> createdOrder = orderService.create(tableId, itemIds);

        assertTrue(createdOrder.isPresent());
    }
}