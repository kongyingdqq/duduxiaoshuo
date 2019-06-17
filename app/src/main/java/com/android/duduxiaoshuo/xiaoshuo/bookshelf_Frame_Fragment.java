package com.android.duduxiaoshuo.xiaoshuo;

import android.os.Bundle;

import com.android.duduxiaoshuo.R;
import com.android.fastapp.xdroidmvp.mvp.XLazyFragment;

public class bookshelf_Frame_Fragment extends XLazyFragment {
    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_bookshelf_frame;
    }

    @Override
    public Object newP() {
        return null;
    }

    public static bookshelf_Frame_Fragment newInstance(){
        return new bookshelf_Frame_Fragment();
    }
}
