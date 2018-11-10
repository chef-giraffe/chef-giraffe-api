package com.chefgiraffe.api.repositories.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class RestaurantOrder {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private UUID restaurantTableId;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "restaurant_order_item",
                joinColumns = @JoinColumn(name = "restaurant_order_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "menu_item_id", referencedColumnName = "id"))
    private List<MenuItem> menuItems;

    protected RestaurantOrder() {
    }

    public RestaurantOrder(UUID restaurantTableId, OrderStatus orderStatus) {
        this.restaurantTableId = restaurantTableId;
        this.menuItems = new ArrayList<>();
        this.orderStatus = orderStatus;
    }

    public RestaurantOrder(UUID restaurantTableId, OrderStatus orderStatus, List<MenuItem> menuItems) {
        this.restaurantTableId = restaurantTableId;
        this.orderStatus = orderStatus;
        this.menuItems = menuItems;
    }

    public UUID getId() {
        return id;
    }

    public UUID getRestaurantTableId() {
        return restaurantTableId;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public boolean addItem(MenuItem menuItem) {
        return this.menuItems.add(menuItem);
    }

    @Override
    public String toString() {
        return "RestaurantOrder{" +
                "id=" + id +
                ", menuItems=" + menuItems +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
