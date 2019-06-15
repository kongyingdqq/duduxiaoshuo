package com.android.duduxiaoshuo.mainpannel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.fastapp.xdroidmvp.mvp.XActivity;

public abstract class BaseActivity extends XActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

    }
}
