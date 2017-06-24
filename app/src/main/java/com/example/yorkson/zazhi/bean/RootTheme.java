package com.example.yorkson.zazhi.bean;
import java.util.List;
/**
 * Created by Yorkson on 2017/6/24.
 */


public class RootTheme {
    private int limit;

    private boolean subscribed ;

    private List<Theme> themes;

    public void setLimit(int limit){
        this.limit = limit;
    }
    public int getLimit(){
        return this.limit;
    }
    public void setSubscribed(boolean subscribed){
        this.subscribed = subscribed;
    }
    public boolean getSubscribed(){
        return this.subscribed;
    }
    public void setThemes(List<Theme> themes){
        this.themes = themes;
    }
    public List<Theme> getThemes(){
        return this.themes;
    }

}