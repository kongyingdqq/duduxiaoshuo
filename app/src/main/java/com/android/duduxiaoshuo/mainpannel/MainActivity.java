package com.android.duduxiaoshuo.mainpannel;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.android.duduxiaoshuo.R;
import com.android.duduxiaoshuo.coupons.CouponsFragment;
import com.android.duduxiaoshuo.me.MeFragment;
import com.android.duduxiaoshuo.news.NewFrameFragment;
import com.android.duduxiaoshuo.tvzhibo.TvzhiboFrameFragment;
import com.android.duduxiaoshuo.xiaoshuo.XiaoshuoFrameFragment;
import com.android.fastapp.xdroidmvp.base.XFragmentAdapter;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_commontablelayout)
    CommonTabLayout mCommonTabLayout;

    @BindView(R.id.ultraviewpager_page_container)
    UltraViewPager mUltraViewPager;
    XFragmentAdapter mUltraViewPagerAdapter;


    ArrayList<CustomTabEntity> mCustomTabEntityList = new ArrayList<>();
    ArrayList<Fragment> mXLazyFragmentList = new ArrayList<>();

    @Override
    public void initData(Bundle savedInstanceState) {

        initCommonTabLayout();

        initViewpager();

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Object newP() {
        return null;
    }


    private void initCommonTabLayout(){

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

        mCommonTabLayout.setTabData(mCustomTabEntityList);
        mCommonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mUltraViewPager.setCurrentItem(position,true);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    private void initViewpager(){

        mXLazyFragmentList.add(XiaoshuoFrameFragment.newInstance());
        mXLazyFragmentList.add(TvzhiboFrameFragment.newInstance());
        mXLazyFragmentList.add(NewFrameFragment.newInstance());
        mXLazyFragmentList.add(CouponsFragment.newInstance());
        mXLazyFragmentList.add(MeFragment.newInstance());

        String[] fragment_title ={getString(R.string.title_xiaoshuo),getString(R.string.title_vipshipin),getString(R.string.title_news),
                getString(R.string.title_youhuijuan),getString(R.string.title_me)};

        mUltraViewPagerAdapter = new XFragmentAdapter(getSupportFragmentManager(),mXLazyFragmentList,fragment_title);
        mUltraViewPager.setAdapter(mUltraViewPagerAdapter);
        mUltraViewPager.setOffscreenPageLimit(fragment_title.length);
        mUltraViewPager.setDisableSlide(true);

        mUltraViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCommonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onBackPressed() {

        if(mCommonTabLayout != null && mCommonTabLayout.getCurrentTab() == 2){

        }
        super.onBackPressed();
    }
}
