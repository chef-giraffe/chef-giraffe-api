package com.chefgiraffe.api.repository;

import com.chefgiraffe.api.repository.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {
}
