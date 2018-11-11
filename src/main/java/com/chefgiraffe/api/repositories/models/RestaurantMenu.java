package com.chefgiraffe.api.repositories.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class RestaurantMenu {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "restaurant_id")
    private UUID restaurantId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_menu_id")
    private List<RestaurantMenuItem> restaurantMenuItems;

    public RestaurantMenu() {
    }

    public RestaurantMenu(UUID restaurantId, String name) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.restaurantMenuItems = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public List<RestaurantMenuItem> getRestaurantMenuItems() {
        return restaurantMenuItems;
    }

    public boolean addRestaurantMenuItem(RestaurantMenuItem restaurantMenuItem) {
        return this.restaurantMenuItems.add(restaurantMenuItem);
    }

    @Override
    public String toString() {
        return "RestaurantMenu{" +
                "id=" + id +
                ", restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", restaurantMenuItems=" + restaurantMenuItems +
                '}';
    }
}
