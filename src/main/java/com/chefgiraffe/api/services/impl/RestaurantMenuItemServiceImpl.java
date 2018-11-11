package com.chefgiraffe.api.services.impl;

import com.chefgiraffe.api.repositories.RestaurantMenuItemRepository;
import com.chefgiraffe.api.repositories.RestaurantMenuRepository;
import com.chefgiraffe.api.repositories.models.RestaurantMenu;
import com.chefgiraffe.api.repositories.models.RestaurantMenuItem;
import com.chefgiraffe.api.services.RestaurantItemService;
import com.chefgiraffe.api.services.models.ItemLookup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RestaurantMenuItemServiceImpl implements RestaurantItemService {
    private RestaurantMenuItemRepository restaurantMenuItemRepository;
    private RestaurantMenuRepository restaurantMenuRepository;
    private static Logger logger = LoggerFactory.getLogger(RestaurantOrderServiceImpl.class);

    @Autowired
    public RestaurantMenuItemServiceImpl(RestaurantMenuItemRepository restaurantMenuItemRepository, RestaurantMenuRepository restaurantMenuRepository) {
        this.restaurantMenuItemRepository = restaurantMenuItemRepository;
        this.restaurantMenuRepository = restaurantMenuRepository;
    }

    @Override
    public Optional<RestaurantMenuItem> create(UUID restaurantMenuId, String name, String description, BigDecimal price, String imageUri) {

        Optional<RestaurantMenu> restaurant = restaurantMenuRepository.findById(restaurantMenuId);

        if (restaurant.isPresent()) {

            logger.debug("creating new Item for restaurant menu {}", restaurantMenuId.toString());
            RestaurantMenuItem newMenuItem =
                    restaurantMenuItemRepository.save(new RestaurantMenuItem(restaurantMenuId, name, description, price, imageUri));

            logger.info("created new item {} for restaurant menu {}", newMenuItem.getId().toString(),
                    newMenuItem.getRestaurantMenuId().toString());
            return Optional.of(newMenuItem);
        } else {
            logger.warn("tried to create an item for unknown restaurant menu {}", restaurantMenuId.toString());
            return Optional.empty();
        }
    }

    @Override
    public List<RestaurantMenuItem> retrieveAll() {
        List<RestaurantMenuItem> restaurantMenuItems = new ArrayList<>();
        restaurantMenuItemRepository.findAll().forEach(restaurantMenuItems::add);
        return restaurantMenuItems;
    }

    @Override
    public Optional<RestaurantMenuItem> retrieve(ItemLookup lookup) {
        Optional<RestaurantMenuItem> restaurantMenuItem = restaurantMenuItemRepository.findById(lookup.getItemId());
        if(restaurantMenuItem.isPresent()){
            logger.info("Item {} found", lookup.getItemId());
            return restaurantMenuItem;
        } else {
            logger.warn("Item {} not found", lookup.getItemId());
            return Optional.empty();
        }
    }

    @Override
    public Optional<RestaurantMenuItem> update(RestaurantMenuItem update) {
        Optional<RestaurantMenuItem> order = restaurantMenuItemRepository.findById(update.getId());
        if (order.isPresent()) {

            RestaurantMenuItem existingOrder = order.get();

            logger.debug("item {} found", existingOrder.getId().toString());

            logger.info("updating item {}", existingOrder.getId().toString());
            RestaurantMenuItem savedUpdatedOrder = restaurantMenuItemRepository.save(update);

            return Optional.of(savedUpdatedOrder);
        } else {
            logger.warn("item {} not found", update.getId().toString());
            return Optional.empty();
        }
    }
}
