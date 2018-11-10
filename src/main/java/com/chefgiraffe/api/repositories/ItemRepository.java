package com.chefgiraffe.api.repositories;

import com.chefgiraffe.api.repositories.models.MenuItem;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ItemRepository extends CrudRepository<MenuItem, UUID> {
}
