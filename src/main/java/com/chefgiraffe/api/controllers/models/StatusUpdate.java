package com.chefgiraffe.api.controllers.models;

public class StatusUpdate {

    private String status;

    public StatusUpdate() {
    }

    public StatusUpdate(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "StatusUpdate{" +
                "status='" + status + '\'' +
                '}';
    }
}
