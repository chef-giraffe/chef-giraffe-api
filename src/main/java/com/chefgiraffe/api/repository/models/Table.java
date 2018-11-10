package com.chefgiraffe.api.repository.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Table {

    @Id
    @GeneratedValue
    private UUID id;
    private String friendlyName;
    private Integer availableSeats;

    public Table() {
    }

    public Table(String friendlyName, Integer availableSeats) {
        this.friendlyName = friendlyName;
        this.availableSeats = availableSeats;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", friendlyName='" + friendlyName + '\'' +
                ", availableSeats=" + availableSeats +
                '}';
    }
}
