package com.chefgiraffe.api.repositories;

import com.chefgiraffe.api.repositories.models.RestaurantRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RequestRepository extends CrudRepository<RestaurantRequest, UUID> {
}
