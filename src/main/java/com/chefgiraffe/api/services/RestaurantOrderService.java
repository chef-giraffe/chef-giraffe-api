package com.chefgiraffe.api.services;

import com.chefgiraffe.api.services.models.*;

import java.util.List;
import java.util.Optional;

public interface RestaurantOrderService {
    List<OrderInfo> retrieveAll();
    Optional<OrderInfo> retrieve(OrderLookup lookup);
    Optional<OrderDetails> retrieveDetails(OrderLookup lookup);
    Optional<CreatedOrder> create(OrderCreate create);
    Optional<UpdatedOrder> update(OrderUpdate update);
}
