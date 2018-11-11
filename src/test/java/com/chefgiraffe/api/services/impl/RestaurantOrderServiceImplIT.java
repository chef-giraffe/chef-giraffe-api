package com.chefgiraffe.api.services.impl;

import com.chefgiraffe.api.repositories.OrderRepository;
import com.chefgiraffe.api.repositories.models.RestaurantOrder;
import com.chefgiraffe.api.services.OrderService;
import com.chefgiraffe.api.services.models.CreatedOrder;
import com.chefgiraffe.api.services.models.OrderStatus;
import com.chefgiraffe.api.services.models.OrderUpdate;
import com.chefgiraffe.api.services.models.UpdatedOrder;
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

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void createOrder_OrderIsCreated() {

        UUID restaurantTableId = UUID.fromString("127e65d0-13a0-4be2-9b5a-ed0635b9c5ce");
        List<UUID> itemIds = Collections.singletonList(UUID.randomUUID());

        Optional<CreatedOrder> createdOrder = orderService.create(restaurantTableId, itemIds);

        assertTrue(createdOrder.isPresent());

        Optional<RestaurantOrder> savedOrder = orderRepository.findById(createdOrder.get().getOrderId());

        assertTrue(savedOrder.isPresent());
        assertEquals(restaurantTableId, savedOrder.get().getRestaurantTableId());
    }

    @Test
    public void updateOrder_OrderIsUpdated() {

        UUID restaurantTableId = UUID.fromString("127e65d0-13a0-4be2-9b5a-ed0635b9c5ce");
        List<UUID> itemIds = Collections.singletonList(UUID.randomUUID());

        Optional<CreatedOrder> createdOrder = orderService.create(restaurantTableId, itemIds);

        assertTrue(createdOrder.isPresent());

        Optional<UpdatedOrder> updatedOrder =
                orderService.update(new OrderUpdate(createdOrder.get().getOrderId(), OrderStatus.PREPARING));

        assertTrue(updatedOrder.isPresent());
        assertEquals(createdOrder.get().getOrderId(), updatedOrder.get().getOrderId());
        assertEquals(OrderStatus.PREPARING, updatedOrder.get().getNewStatus());
    }
}