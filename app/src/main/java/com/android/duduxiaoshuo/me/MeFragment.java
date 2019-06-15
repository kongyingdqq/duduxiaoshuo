package com.android.duduxiaoshuo.me;

import android.os.Bundle;

import com.android.duduxiaoshuo.R;
import com.android.fastapp.xdroidmvp.mvp.XLazyFragment;

public class MeFragment extends XLazyFragment {
    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_meframe;
    }

    @Override
    public Object newP() {
        return null;
    }

    public static MeFragment newInstance(){
        return new MeFragment();
    }
}
