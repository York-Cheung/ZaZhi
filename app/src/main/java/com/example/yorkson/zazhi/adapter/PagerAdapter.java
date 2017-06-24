package com.example.yorkson.zazhi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yorkson.zazhi.ui.fragment.BoringFragment;
import com.example.yorkson.zazhi.ui.fragment.DesignFragment;
import com.example.yorkson.zazhi.ui.fragment.GameFragment;
import com.example.yorkson.zazhi.ui.fragment.MovieFragment;
import com.example.yorkson.zazhi.ui.fragment.SafetyFragment;
import com.example.yorkson.zazhi.ui.fragment.TodayFragment;
import com.example.yorkson.zazhi.ui.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {
    private final String[] title={"今日日报","用户推荐日报","电影日报","不许无聊","设计日报","开始游戏","互联网安全"};
    private List<Fragment>fragments=new ArrayList<Fragment>();

    public PagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new TodayFragment());
        fragments.add(new UserFragment());
        fragments.add(new MovieFragment());
        fragments.add(new BoringFragment());
        fragments.add(new DesignFragment());
        fragments.add(new GameFragment());
        fragments.add(new SafetyFragment());
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return 7;
    }
}
