package com.android.duduxiaoshuo.xiaoshuo;

import android.os.Bundle;

import com.android.duduxiaoshuo.R;
import com.android.fastapp.xdroidmvp.mvp.XLazyFragment;

public class bookhot_Frame_Fragment extends XLazyFragment {
    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_bookhot_frame;
    }

    @Override
    public Object newP() {
        return null;
    }

    public static bookhot_Frame_Fragment newInstance(){
        return new bookhot_Frame_Fragment();
    }
}
