package com.chefgiraffe.api.services;

import com.chefgiraffe.api.services.models.CreatedTable;
import com.chefgiraffe.api.services.models.TableCreate;
import com.chefgiraffe.api.services.models.TableInfo;
import com.chefgiraffe.api.services.models.TableLookup;

import java.util.List;
import java.util.Optional;

public interface RestaurantTableService {

    List<TableInfo> retrieveAll();
    Optional<TableInfo> retrieve(TableLookup lookup);
    Optional<CreatedTable> create(TableCreate create);
}
