package com.chefgiraffe.api.repositories;

import com.chefgiraffe.api.repositories.models.RestaurantMenuItem;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RestaurantMenuItemRepository extends CrudRepository<RestaurantMenuItem, UUID> {
}
