package com.chefgiraffe.api.services;

import com.chefgiraffe.api.services.models.CreatedOrder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    Optional<CreatedOrder> create(UUID tableId, List<UUID> items);
}
