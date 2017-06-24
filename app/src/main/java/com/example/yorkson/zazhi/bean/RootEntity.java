package com.example.yorkson.zazhi.bean;

import java.util.ArrayList;


public class RootEntity {
    private ArrayList<StoriesEntity> stories ;
    public void setStories(ArrayList<StoriesEntity> stories){
        this.stories = stories;
    }
    public ArrayList<StoriesEntity> getStories(){
        return this.stories;
    }
}
