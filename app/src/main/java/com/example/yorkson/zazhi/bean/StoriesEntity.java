package com.example.yorkson.zazhi.bean;

import java.util.List;

public class StoriesEntity {
    private int id;
    private String title;
    private List<String> images;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getImages() {
        return images;
    }



}
