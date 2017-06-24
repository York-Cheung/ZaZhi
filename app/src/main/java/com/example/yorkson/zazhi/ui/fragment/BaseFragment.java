package com.example.yorkson.zazhi.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.yorkson.zazhi.R;
import com.example.yorkson.zazhi.ZhiHuService;
import com.example.yorkson.zazhi.adapter.NewsAdapter;
import com.example.yorkson.zazhi.bean.RootEntity;
import com.example.yorkson.zazhi.bean.StoriesEntity;
import com.example.yorkson.zazhi.ui.activity.StoryDetailActivity;

import java.util.ArrayList;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {

    private String baseUrl="http://news-at.zhihu.com";//baseUrl
    public ZhiHuService service;//获取消息，子Fragment用

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        service=getService();
        return inflater.inflate(R.layout.fragment_base, container, false);
    }


    public ZhiHuService getService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        service=retrofit.create(ZhiHuService.class);
        return service;
    }

    public void loadDataSetLis(Observable<RootEntity> rootEntityObservable, final ListView listView){
        rootEntityObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<RootEntity, ArrayList<StoriesEntity>>() {
                    @Override
                    public ArrayList<StoriesEntity> call(RootEntity rootEntity) {
                        return rootEntity.getStories();
                    }
                })
                .subscribe(new Subscriber<ArrayList<StoriesEntity>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(final ArrayList<StoriesEntity> storiesEntities) {
                        listView.setAdapter(new NewsAdapter(storiesEntities,getContext()));
                        //点击item跳转到详细页面
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent=new Intent(getActivity(),StoryDetailActivity.class);
                                intent.putExtra("id",storiesEntities.get(position).getId());
                                startActivity(intent);
                            }
                        });
                    }
                });
    }
}
