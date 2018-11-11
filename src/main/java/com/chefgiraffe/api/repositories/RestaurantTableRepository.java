package com.chefgiraffe.api.repositories;

import com.chefgiraffe.api.repositories.models.RestaurantTable;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RestaurantTableRepository extends CrudRepository<RestaurantTable, UUID> {
}
