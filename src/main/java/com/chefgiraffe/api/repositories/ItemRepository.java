package com.chefgiraffe.api.repositories;

import com.chefgiraffe.api.repositories.models.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {
}
