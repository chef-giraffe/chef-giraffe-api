package com.chefgiraffe.api.repositories;

import com.chefgiraffe.api.repositories.models.RestaurantMenu;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RestaurantMenuRepository extends CrudRepository<RestaurantMenu, UUID> {
}
