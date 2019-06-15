package com.android.duduxiaoshuo.xiaoshuo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.android.duduxiaoshuo.R;
import com.android.duduxiaoshuo.tvzhibo.TvVideo_Frame_Fragment;
import com.android.duduxiaoshuo.tvzhibo.VipVideo_Frame_Fragment;
import com.android.fastapp.xdroidmvp.base.XFragmentAdapter;
import com.android.fastapp.xdroidmvp.mvp.XLazyFragment;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;

import butterknife.BindView;

public class XiaoshuoFrameFragment extends XLazyFragment {

    @BindView(R.id.video_top_SegmentTabLayout)
    SegmentTabLayout video_top_SegmentTabLayout;

    @BindView(R.id.ultraviewpager_page_container)
    UltraViewPager ultraviewpager_page_container;

    XFragmentAdapter mUltraViewPagerAdapter;
    ArrayList<Fragment> mXLazyFragmentList = new ArrayList<>();
    String[] mTitles ;


    @Override
    public void initData(Bundle savedInstanceState) {

        mTitles = new String[]{getString(R.string.title_xiaoshuo_bookshelf),
                getString(R.string.title_xiaoshuo_hot),getString(R.string.title_xiaoshuo_Categories)};
        initVideoTopTab();
        initUltraViewPager();

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_xiaoshuoframe;
    }

    @Override
    public Object newP() {
        return null;
    }

    private void initVideoTopTab() {
        video_top_SegmentTabLayout.setTabData(mTitles);
        video_top_SegmentTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if(ultraviewpager_page_container != null){
                    ultraviewpager_page_container.setCurrentItem(position,true);
                }
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

    }

    private void initUltraViewPager() {


        mXLazyFragmentList.add(bookshelf_Frame_Fragment.newInstance());
        mXLazyFragmentList.add(bookhot_Frame_Fragment.newInstance());
        mXLazyFragmentList.add(bookcategories_Frame_Fragment.newInstance());


        mUltraViewPagerAdapter = new XFragmentAdapter(getActivity().getSupportFragmentManager(),mXLazyFragmentList,mTitles);
        ultraviewpager_page_container.setAdapter(mUltraViewPagerAdapter);
        ultraviewpager_page_container.setOffscreenPageLimit(mTitles.length);
        ultraviewpager_page_container.setDisableSlide(false);

        ultraviewpager_page_container.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                video_top_SegmentTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public static XiaoshuoFrameFragment newInstance(){
        return new XiaoshuoFrameFragment();
    }
}
