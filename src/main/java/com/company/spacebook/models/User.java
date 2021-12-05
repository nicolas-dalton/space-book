package com.company.spacebook.models;

import java.util.List;

public class User {
    private String name;
    private List<SpacePost> spacePosts;
    // CONSTRUCTOR
    public User(String name){
        this.name = name;
    }
    // GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SpacePost> getSpacePosts() {
        return spacePosts;
    }

    public void setSpacePosts(List<SpacePost> spacePosts) {
        this.spacePosts = spacePosts;
    }
}
