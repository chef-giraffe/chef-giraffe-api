package com.chefgiraffe.api.services.impl;

import com.chefgiraffe.api.repositories.ItemRepository;
import com.chefgiraffe.api.repositories.OrderRepository;
import com.chefgiraffe.api.repositories.TableRepository;
import com.chefgiraffe.api.repositories.models.RestaurantOrder;
import com.chefgiraffe.api.repositories.models.RestaurantTable;
import com.chefgiraffe.api.services.OrderService;
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
public class OrderServiceImpl implements OrderService {

    private static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final TableRepository tableRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(TableRepository tableRepository, ItemRepository itemRepository, OrderRepository orderRepository) {
        this.tableRepository = tableRepository;
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Optional<CreatedOrder> create(UUID tableId, List<UUID> items) {

        Optional<RestaurantTable> table = tableRepository.findById(tableId);
        if (table.isPresent()) {

            logger.debug("table {} found - creating new order", table.get().getId().toString());
            RestaurantOrder newRestaurantOrder =
                    new RestaurantOrder(table.get().getId(), OrderStatus.CREATED.toString());

            itemRepository.findAllById(items).forEach(newRestaurantOrder::addItem);

            logger.info("saving new order for table {}", tableId.toString());
            RestaurantOrder savedRestaurantOrder = orderRepository.save(newRestaurantOrder);

            return Optional.of(new CreatedOrder(savedRestaurantOrder.getId(),
                                                savedRestaurantOrder.getRestaurantTableId(),
                                                savedRestaurantOrder.getMenuItems().size()));
        } else {
            logger.warn("table {} not found", tableId.toString());
            return Optional.empty();
        }
    }

    @Override
    public Optional<UpdatedOrder> update(OrderUpdate update) {

        Optional<RestaurantOrder> order = orderRepository.findById(update.getOrderId());
        if (order.isPresent()) {

            RestaurantOrder existingOrder = order.get();

            logger.debug("order {} found", existingOrder.getId().toString());

            existingOrder.updateStatus(update.getUpdateStatus().toString());

            RestaurantOrder savedUpdatedOrder = orderRepository.save(existingOrder);

            return Optional.of(new UpdatedOrder(savedUpdatedOrder.getId(),
                                                savedUpdatedOrder.getRestaurantTableId(),
                                                OrderStatus.valueOf(savedUpdatedOrder.getOrderStatus())));

        } else {
            logger.warn("order {} not found", update.getOrderId().toString());
            return Optional.empty();
        }
    }
}
