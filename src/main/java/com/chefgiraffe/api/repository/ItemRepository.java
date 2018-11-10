package com.chefgiraffe.api.repository;

import com.chefgiraffe.api.repository.models.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {
}
