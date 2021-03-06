package com.chefgiraffe.api.repositories.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    @Column(name = "restaurant_table_id")
    private UUID restaurantTableId;
    private String orderStatus;
    private Timestamp createdTime;
    private Timestamp updatedTime;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "restaurant_order_item",
                joinColumns = @JoinColumn(name = "restaurant_order_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "restaurant_menu_item_id", referencedColumnName = "id"))
    private List<RestaurantMenuItem> restaurantMenuItems;

    protected RestaurantOrder() {
    }

    public RestaurantOrder(UUID restaurantTableId, String orderStatus, Timestamp createdTime) {
        this.restaurantTableId = restaurantTableId;
        this.createdTime = createdTime;
        this.restaurantMenuItems = new ArrayList<>();
        this.orderStatus = orderStatus;
    }

    public UUID getId() {
        return id;
    }

    public UUID getRestaurantTableId() {
        return restaurantTableId;
    }

    public List<RestaurantMenuItem> getRestaurantMenuItems() {
        return restaurantMenuItems;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public boolean addItem(RestaurantMenuItem restaurantMenuItem) {
        return this.restaurantMenuItems.add(restaurantMenuItem);
    }

    public void updateStatus(String newStatus) {
        this.orderStatus = newStatus;
        this.updatedTime = Timestamp.valueOf(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "RestaurantOrder{" +
                "id=" + id +
                ", restaurantTableId=" + restaurantTableId +
                ", orderStatus='" + orderStatus + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", restaurantMenuItems=" + restaurantMenuItems +
                '}';
    }
}
