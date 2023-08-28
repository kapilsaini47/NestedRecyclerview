package com.example.nestedrecyclerview.model;

public class ChildModel {

    // Declare a member variable to store the String value of the child item
    String item = new String("");

    // Constructor for creating a ChildModel object with a title
    public ChildModel(String item) {
        this.item = item;
    }

    // Getter method to retrieve the title of the child item
    public String getItem() {
        return item;
    }

    // Setter method to set the title of the child item
    public void setItem(String item) {
        this.item = item;
    }
}
