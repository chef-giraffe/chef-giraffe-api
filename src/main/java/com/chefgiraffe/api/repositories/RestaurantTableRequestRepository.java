package com.chefgiraffe.api.repositories;

import com.chefgiraffe.api.repositories.models.RestaurantTableRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RestaurantTableRequestRepository extends CrudRepository<RestaurantTableRequest, UUID> {
}
