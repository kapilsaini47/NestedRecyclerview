package com.example.nestedrecyclerview.model;

import java.util.ArrayList;

public class ParentModel {

    // Declare a member variable to store the title and list of Child Model of the Parent item
    ArrayList<ChildModel> data = new ArrayList<ChildModel>();
    String title = new String();

    //Constructor for creating a ParentModel object with a Array list of Child model and title
    public ParentModel(ArrayList<ChildModel> data, String title) {
        this.data = data;
        this.title = title;
    }

    //Getter method to retrieve title of parent
    public String getTitle() {
        return title;
    }

    //Setter to set the title of parent
    public void setTitle(String title) {
        this.title = title;
    }

    //Getter method to retrieve list from parent
    public ArrayList<ChildModel> getData() {
        return data;
    }

    //Setter to set the list of parent
    public void setData(ArrayList<ChildModel> data) {
        this.data = data;
    }


}
