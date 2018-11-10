package com.chefgiraffe.api.repositories;

import com.chefgiraffe.api.repositories.models.RestaurantOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<RestaurantOrder, UUID> {
}
