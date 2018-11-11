package com.chefgiraffe.api.services;

import com.chefgiraffe.api.services.models.CreatedRequest;
import com.chefgiraffe.api.services.models.RequestCreate;

import java.util.Optional;

public interface RestaurantRequestService {
    Optional<CreatedRequest> create(RequestCreate create);
}
