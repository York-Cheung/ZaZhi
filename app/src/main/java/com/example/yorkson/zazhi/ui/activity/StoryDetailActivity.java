package com.example.yorkson.zazhi.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;

import com.example.yorkson.zazhi.R;
import com.example.yorkson.zazhi.ZhiHuService;
import com.example.yorkson.zazhi.bean.StoryDetailsEntity;
import com.example.yorkson.zazhi.util.HtmlUtils;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class StoryDetailActivity extends AppCompatActivity {
    private WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);
        //左上角出现小箭头
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        wv= (WebView) findViewById(R.id.webView);
        Intent intent=getIntent();

        String baseUrl="http://news-at.zhihu.com";
        int id=intent.getIntExtra("id",0);
        // 创建Retrofit 实例
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        // 创建API 接口
        ZhiHuService service=retrofit.create(ZhiHuService.class);

        service.getNewsDetails(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<StoryDetailsEntity, String>() {
                    @Override
                    public String call(StoryDetailsEntity storyDetailsEntity) {
                        return  HtmlUtils.structHtml(storyDetailsEntity);
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error",e.toString());
                    }

                    @Override
                    public void onNext(String s) {
                        //加载asset里的css
                        wv.loadDataWithBaseURL("file:///android_asset/", s, "text/html", "UTF-8", null);
                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        //点击小箭头返回
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
