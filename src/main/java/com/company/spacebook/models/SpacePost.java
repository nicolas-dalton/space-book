package com.company.spacebook.models;

public class SpacePost {
    private String text;
    //CONSTRUCTOR
    public SpacePost(String input){
        text= input;
    }
    // GETTERS AND SETTERS
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
