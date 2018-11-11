package com.chefgiraffe.api.services;

import com.chefgiraffe.api.services.models.*;

import java.util.List;
import java.util.Optional;

public interface RestaurantTableService {

    List<TableInfo> retrieveAll();
    Optional<TableInfo> retrieve(TableLookup lookup);
    Optional<TableOrderDetails> retrieveAllOrders(TableLookup lookup);
    Optional<TableOrderDetails> retrieveSpecificOrders(TableLookup lookup);
    Optional<CreatedRequest> createTableRequest(RequestCreate create);
    Optional<TableRequestDetails> retrieveTableRequestDetails(TableLookup lookup);
    Optional<CreatedTable> create(TableCreate create);
}
