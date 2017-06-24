package com.example.yorkson.zazhi.bean;

/**
 * Created by Yorkson on 2017/6/24.
 */

public class Theme {
    private int color;

    private String thumbnail;

    private String description;

    private int id;

    private String name;

    public void setColor(int color){
        this.color = color;
    }
    public int getColor(){
        return this.color;
    }
    public void setThumbnail(String thumbnail){
        this.thumbnail = thumbnail;
    }
    public String getThumbnail(){
        return this.thumbnail;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

}
