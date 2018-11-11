package com.chefgiraffe.api.services.impl;

import com.chefgiraffe.api.repositories.RestaurantOrderRepository;
import com.chefgiraffe.api.repositories.models.RestaurantOrder;
import com.chefgiraffe.api.services.RestaurantOrderService;
import com.chefgiraffe.api.services.models.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantOrderServiceImplIT {

    @Autowired
    private RestaurantOrderService restaurantOrderService;

    @Autowired
    private RestaurantOrderRepository restaurantOrderRepository;

    @Test
    public void createOrder_OrderIsCreated() {

        UUID restaurantTableId = UUID.fromString("127e65d0-13a0-4be2-9b5a-ed0635b9c5ce");
        List<UUID> restaurantMenuItemIds = Arrays.asList(UUID.fromString("9d725f88-3f9f-477f-af88-3a8f09dbb6fb"),
                                                         UUID.fromString("544305ca-3526-47d1-9b9e-6aca1bf8cdeb"));

        Optional<CreatedOrder> createdOrder =
                restaurantOrderService.create(new OrderCreate(restaurantTableId, restaurantMenuItemIds));

        assertTrue(createdOrder.isPresent());

        Optional<RestaurantOrder> savedOrder = restaurantOrderRepository.findById(createdOrder.get().getId());

        assertTrue(savedOrder.isPresent());
        assertEquals(restaurantTableId, savedOrder.get().getRestaurantTableId());
    }

    @Test
    public void updateOrder_OrderIsUpdated() {

        UUID restaurantTableId = UUID.fromString("127e65d0-13a0-4be2-9b5a-ed0635b9c5ce");
        List<UUID> restaurantMenuItemIds = Arrays.asList(UUID.fromString("9d725f88-3f9f-477f-af88-3a8f09dbb6fb"),
                                           UUID.fromString("544305ca-3526-47d1-9b9e-6aca1bf8cdeb"));

        Optional<CreatedOrder> createdOrder =
                restaurantOrderService.create(new OrderCreate(restaurantTableId, restaurantMenuItemIds));

        assertTrue(createdOrder.isPresent());

        Optional<UpdatedOrder> updatedOrder =
                restaurantOrderService.update(new OrderUpdate(createdOrder.get().getId(), OrderStatus.PREPARING));

        assertTrue(updatedOrder.isPresent());
        assertEquals(createdOrder.get().getId(), updatedOrder.get().getId());
        assertEquals(OrderStatus.PREPARING, updatedOrder.get().getNewStatus());
    }
}