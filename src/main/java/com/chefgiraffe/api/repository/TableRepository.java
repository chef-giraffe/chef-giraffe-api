package com.chefgiraffe.api.repository;

import com.chefgiraffe.api.repository.models.Table;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TableRepository extends CrudRepository<Table, UUID> {
}
