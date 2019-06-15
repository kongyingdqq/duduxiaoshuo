package com.android.duduxiaoshuo.tvzhibo;

import android.os.Bundle;

import com.android.duduxiaoshuo.R;
import com.android.fastapp.xdroidmvp.mvp.XLazyFragment;

public class TvVideo_Frame_Fragment extends XLazyFragment {
    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_tvvideo_frame;
    }

    @Override
    public Object newP() {
        return null;
    }

    public static TvVideo_Frame_Fragment newInstance(){
        return new TvVideo_Frame_Fragment();
    }
}
