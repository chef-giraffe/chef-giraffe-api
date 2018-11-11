package com.chefgiraffe.api.services.impl;

import com.chefgiraffe.api.repositories.RestaurantMenuItemRepository;
import com.chefgiraffe.api.repositories.RestaurantOrderRepository;
import com.chefgiraffe.api.repositories.RestaurantTableRepository;
import com.chefgiraffe.api.repositories.models.RestaurantOrder;
import com.chefgiraffe.api.repositories.models.RestaurantTable;
import com.chefgiraffe.api.services.RestaurantOrderService;
import com.chefgiraffe.api.services.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantOrderServiceImpl implements RestaurantOrderService {

    private static Logger logger = LoggerFactory.getLogger(RestaurantOrderServiceImpl.class);

    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantMenuItemRepository restaurantMenuItemRepository;
    private final RestaurantOrderRepository restaurantOrderRepository;

    @Autowired
    public RestaurantOrderServiceImpl(RestaurantTableRepository restaurantTableRepository,
                                      RestaurantMenuItemRepository restaurantMenuItemRepository,
                                      RestaurantOrderRepository restaurantOrderRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
        this.restaurantOrderRepository = restaurantOrderRepository;
        this.restaurantMenuItemRepository = restaurantMenuItemRepository;
    }

    @Override
    public List<OrderInfo> retrieveAll() {

        List<OrderInfo> orders = new ArrayList<>();
        restaurantOrderRepository.findAll().forEach(restaurantOrder ->
                orders.add(new OrderInfo(restaurantOrder.getId(),
                                         restaurantOrder.getRestaurantTableId(),
                                         restaurantOrder.getOrderStatus())));

        return orders;
    }

    @Override
    public Optional<OrderInfo> retrieve(OrderLookup lookup) {

        Optional<RestaurantOrder> order = restaurantOrderRepository.findById(lookup.getOrderId());
        if (order.isPresent()) {

            logger.info("found order {} for lookup", order.get().getId());
            return Optional.of(new OrderInfo(order.get().getId(),
                                             order.get().getRestaurantTableId(),
                                             order.get().getOrderStatus()));
        } else {
            logger.warn("order {} not found", lookup.getOrderId());
            return Optional.empty();
        }
    }

    @Override
    public Optional<OrderDetails> retrieveDetails(OrderLookup lookup) {

        Optional<RestaurantOrder> order = restaurantOrderRepository.findById(lookup.getOrderId());
        if (order.isPresent()) {

            logger.info("found order {} for details lookup", order.get().getId());

            List<ItemDetails> itemDetails =
                    order.get().getRestaurantMenuItems().stream()
                            .map(restaurantMenuItem ->
                                new ItemDetails(restaurantMenuItem.getId(),
                                                restaurantMenuItem.getRestaurantMenuId(),
                                                restaurantMenuItem.getName(),
                                                restaurantMenuItem.getDescription(),
                                                restaurantMenuItem.getPrice(),
                                                restaurantMenuItem.getImageUri()))
                            .collect(Collectors.toList());

            return Optional.of(new OrderDetails(order.get().getId(), order.get().getRestaurantTableId(), itemDetails));
        } else {
            logger.warn("order {} not found", lookup.getOrderId());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CreatedOrder> create(OrderCreate create) {

        Optional<RestaurantTable> table = restaurantTableRepository.findById(create.getRestaurantTableId());
        if (table.isPresent()) {

            logger.debug("creating new order for table {}", table.get().getId().toString());
            RestaurantOrder newRestaurantOrder =
                    new RestaurantOrder(table.get().getId(), OrderStatus.CREATED.toString());

            restaurantMenuItemRepository.findAllById(create.getRestaurantMenuItemIds()).forEach(newRestaurantOrder::addItem);

            logger.info("saving new order for table {}", newRestaurantOrder.getRestaurantTableId().toString());
            RestaurantOrder savedRestaurantOrder = restaurantOrderRepository.save(newRestaurantOrder);

            return Optional.of(new CreatedOrder(savedRestaurantOrder.getId(),
                                                savedRestaurantOrder.getRestaurantTableId(),
                                                savedRestaurantOrder.getRestaurantMenuItems().size()));
        } else {
            logger.warn("table {} not found", create.getRestaurantTableId().toString());
            return Optional.empty();
        }
    }

    @Override
    public Optional<UpdatedOrder> update(OrderUpdate update) {

        Optional<RestaurantOrder> order = restaurantOrderRepository.findById(update.getOrderId());
        if (order.isPresent()) {

            RestaurantOrder existingOrder = order.get();

            logger.debug("order {} found", existingOrder.getId().toString());

            existingOrder.updateStatus(update.getUpdateStatus().toString());

            logger.info("updating order {}", existingOrder.getId().toString());
            RestaurantOrder savedUpdatedOrder = restaurantOrderRepository.save(existingOrder);

            return Optional.of(new UpdatedOrder(savedUpdatedOrder.getId(),
                                                savedUpdatedOrder.getRestaurantTableId(),
                                                OrderStatus.valueOf(savedUpdatedOrder.getOrderStatus())));

        } else {
            logger.warn("order {} not found", update.getOrderId().toString());
            return Optional.empty();
        }
    }
}
