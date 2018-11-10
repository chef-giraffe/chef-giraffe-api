package com.chefgiraffe.api.repositories;

import com.chefgiraffe.api.repositories.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {
}