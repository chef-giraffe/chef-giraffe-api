package com.chefgiraffe.api.repositories;

import com.chefgiraffe.api.repositories.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RestaurantRepository extends CrudRepository<Restaurant, UUID> {
}
