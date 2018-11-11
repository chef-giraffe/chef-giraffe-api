package com.chefgiraffe.api.controllers.models;

public class Request {

    private String description;

    public Request() {
    }

    public Request(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Request{" +
                "description='" + description + '\'' +
                '}';
    }
}
