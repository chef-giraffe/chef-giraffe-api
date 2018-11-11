package com.chefgiraffe.api.services;

import com.chefgiraffe.api.services.models.CreatedOrder;
import com.chefgiraffe.api.services.models.OrderUpdate;
import com.chefgiraffe.api.services.models.UpdatedOrder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RestaurantOrderService {
    Optional<CreatedOrder> create(UUID tableId, List<UUID> items);
    Optional<UpdatedOrder> update(OrderUpdate update);
}
