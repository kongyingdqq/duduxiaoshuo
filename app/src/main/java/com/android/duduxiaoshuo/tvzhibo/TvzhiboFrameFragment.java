package com.android.duduxiaoshuo.tvzhibo;

import android.os.Bundle;

import com.android.duduxiaoshuo.R;
import com.android.fastapp.xdroidmvp.mvp.XLazyFragment;

public class TvzhiboFrameFragment extends XLazyFragment {
    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_vipzhiboframe;
    }

    @Override
    public Object newP() {
        return null;
    }

    public static TvzhiboFrameFragment newInstance(){
        return new TvzhiboFrameFragment();
    }
}
