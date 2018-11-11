package com.chefgiraffe.api.services.impl;

import com.chefgiraffe.api.repositories.RestaurantMenuItemRepository;
import com.chefgiraffe.api.repositories.RestaurantOrderRepository;
import com.chefgiraffe.api.repositories.RestaurantTableRepository;
import com.chefgiraffe.api.repositories.models.RestaurantOrder;
import com.chefgiraffe.api.repositories.models.RestaurantTable;
import com.chefgiraffe.api.services.RestaurantOrderService;
import com.chefgiraffe.api.services.models.CreatedOrder;
import com.chefgiraffe.api.services.models.OrderStatus;
import com.chefgiraffe.api.services.models.OrderUpdate;
import com.chefgiraffe.api.services.models.UpdatedOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantOrderServiceImpl implements RestaurantOrderService {

    private static Logger logger = LoggerFactory.getLogger(RestaurantOrderServiceImpl.class);

    private final RestaurantTableRepository restaurantTableRepository;
    private final RestaurantMenuItemRepository restaurantMenuItemRepository;
    private final RestaurantOrderRepository restaurantOrderRepository;

    @Autowired
    public RestaurantOrderServiceImpl(RestaurantTableRepository restaurantTableRepository, RestaurantMenuItemRepository restaurantMenuItemRepository, RestaurantOrderRepository restaurantOrderRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
        this.restaurantOrderRepository = restaurantOrderRepository;
        this.restaurantMenuItemRepository = restaurantMenuItemRepository;
    }

    @Override
    public Optional<CreatedOrder> create(UUID tableId, List<UUID> items) {

        Optional<RestaurantTable> table = restaurantTableRepository.findById(tableId);
        if (table.isPresent()) {

            logger.debug("table {} found - creating new order", table.get().getId().toString());
            RestaurantOrder newRestaurantOrder =
                    new RestaurantOrder(table.get().getId(), OrderStatus.CREATED.toString());

            restaurantMenuItemRepository.findAllById(items).forEach(newRestaurantOrder::addItem);

            logger.info("saving new order for table {}", tableId.toString());
            RestaurantOrder savedRestaurantOrder = restaurantOrderRepository.save(newRestaurantOrder);

            return Optional.of(new CreatedOrder(savedRestaurantOrder.getId(),
                                                savedRestaurantOrder.getRestaurantTableId(),
                                                savedRestaurantOrder.getRestaurantMenuItems().size()));
        } else {
            logger.warn("table {} not found", tableId.toString());
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
