package com.chefgiraffe.api.repositories;

import com.chefgiraffe.api.repositories.models.Table;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TableRepository extends CrudRepository<Table, UUID> {
}
