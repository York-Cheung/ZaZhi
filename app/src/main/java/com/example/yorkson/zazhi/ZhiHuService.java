package com.example.yorkson.zazhi;

import com.example.yorkson.zazhi.bean.RootEntity;
import com.example.yorkson.zazhi.bean.RootTheme;
import com.example.yorkson.zazhi.bean.StoryDetailsEntity;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface ZhiHuService {
    //今日日报
    @GET("/api/4/news/latest")
    Observable<RootEntity> getLatestNews();
    //所有主题
    @GET("/api/4/themes")
    Observable<RootTheme> getThemes();

    //用户推荐日报
    @GET("/api/4/theme/12")
    Observable<RootEntity> getUser();
    //电影日报
    @GET("/api/4/theme/3")
    Observable<RootEntity> getMovie();
    //不许无聊
    @GET("/api/4/theme/11")
    Observable<RootEntity> getBoring();
    //设计日报
    @GET("/api/4/theme/4")
    Observable<RootEntity> getDesign();
    //开始游戏
    @GET("/api/4/theme/2")
    Observable<RootEntity> getGame();
    //互联网安全
    @GET("/api/4/theme/10")
    Observable<RootEntity> getSafety();


    //传入id查看详细信息
    @GET("/api/4/news/{id}")
    Observable<StoryDetailsEntity> getNewsDetails(@Path("id") int id);

}
