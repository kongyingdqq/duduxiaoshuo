package com.android.duduxiaoshuo.xiaoshuo;

import android.os.Bundle;

import com.android.duduxiaoshuo.R;
import com.android.fastapp.xdroidmvp.mvp.XLazyFragment;

public class XiaoshuoFrameFragment extends XLazyFragment {
    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_xiaoshuoframe;
    }

    @Override
    public Object newP() {
        return null;
    }

    public static XiaoshuoFrameFragment newInstance(){
        return new XiaoshuoFrameFragment();
    }
}
