package com.example.yorkson.zazhi.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ListView;

import com.example.yorkson.zazhi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends BaseFragment {
    private ListView lv;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        lv= (ListView) view.findViewById(R.id.lvnews);
        loadDataSetLis(service.getMovie(),lv);
    }
}
