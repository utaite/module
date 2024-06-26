package com.yuyu.module.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.RxFragment;
import com.yuyu.module.R;

import butterknife.ButterKnife;

public class TabFragment1 extends RxFragment {

    private final String TAG = TabFragment1.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_1, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
