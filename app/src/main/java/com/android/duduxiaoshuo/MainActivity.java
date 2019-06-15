package com.android.duduxiaoshuo;

import android.os.Bundle;

import com.android.duduxiaoshuo.me.TabEntityBean;
import com.android.fastapp.xdroidmvp.mvp.XActivity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends XActivity {

    @BindView(R.id.bottom_commontablelayout)
    CommonTabLayout mCommonTabLayout;

    @BindView(R.id.ultraviewpager_page_container)
    UltraViewPager mUltraViewPager;


    ArrayList<CustomTabEntity> mCustomTabEntityList = new ArrayList<>();

    @Override
    public void initData(Bundle savedInstanceState) {

        initTabEntitydata();

        mCommonTabLayout.setTabData(mCustomTabEntityList);
        mCommonTabLayout.setIndicatorAnimEnable(true);


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Object newP() {
        return null;
    }


    private void initTabEntitydata(){

        mCustomTabEntityList.add(new TabEntityBean(getString(R.string.title_xiaoshuo),
                R.drawable.vector_drawable_xiaoshuo_focus,R.drawable.vector_drawable_xiaoshuo_unfocus));

        mCustomTabEntityList.add(new TabEntityBean(getString(R.string.title_vipshipin),
                R.drawable.vector_drawable_vipvideo_focus,R.drawable.vector_drawable_vipvideo_unfocus));

        mCustomTabEntityList.add(new TabEntityBean(getString(R.string.title_news),
                R.drawable.vector_drawable_news_focus,R.drawable.vector_drawable_news_unfocus));

        mCustomTabEntityList.add(new TabEntityBean(getString(R.string.title_youhuijuan),
                R.drawable.vector_drawable_youhuijuan_focus,R.drawable.vector_drawable_youhuijuan_unfocus));

        mCustomTabEntityList.add(new TabEntityBean(getString(R.string.title_me),
                R.drawable.vector_drawable_wode_focus,R.drawable.vector_drawable_wode_unfocus));
    }

}
