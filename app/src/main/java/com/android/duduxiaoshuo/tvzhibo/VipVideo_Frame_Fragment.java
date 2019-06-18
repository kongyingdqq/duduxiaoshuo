package com.android.duduxiaoshuo.tvzhibo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.duduxiaoshuo.R;
import com.android.duduxiaoshuo.config.Commonconfig;
import com.android.duduxiaoshuo.tvzhibo.model.VipVideoViewHolder;
import com.android.duduxiaoshuo.tvzhibo.model.VipWeb;
import com.android.duduxiaoshuo.webs.BrowserActivity;
import com.android.duduxiaoshuo.webs.VideoBrowserActivity;
import com.android.fastapp.xdroidmvp.mvp.XLazyFragment;
import com.android.marqueeview.MarqueeView;
import com.bumptech.glide.Glide;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import cn.droidlover.xrecyclerview.RecyclerAdapter;
import cn.droidlover.xrecyclerview.XRecyclerView;

public class VipVideo_Frame_Fragment extends XLazyFragment {

    @BindView(R.id.top_banner)
    Banner top_banner;

    @BindView(R.id.vipvideo_tips)
    MarqueeView vipvideo_tips;

    @BindView(R.id.vipvideo_container)
    XRecyclerView vipvideo_container;

    @BindView(R.id.othervideo_container)
    XRecyclerView othervideo_container;

    private List<VipWeb> mVipWebList = new ArrayList<>();
    private List<VipWeb> mOtherWebList = new ArrayList<>();


    @Override
    public void initData(Bundle savedInstanceState) {

        initBanner();
        initMarqueeView();
        initVipVideoContainer();
        initOtherVideoContainer();
    }


    @Override
    public int getLayoutId() {
        return R.layout.layout_vipvideo_frame;
    }

    @Override
    public Object newP() {
        return null;
    }


    private void initBanner() {

        List imagelist = Arrays.asList(Commonconfig.TOP_BANNEL_URL);
        top_banner.setDelayTime(3000);
        top_banner.setImages(imagelist)
                .setImageLoader(new BannelGlideImageLoader())
                .start();
    }

    private void initMarqueeView() {

        vipvideo_tips.startWithText(getString(R.string.title_video_vip_tips));
    }

    private void initVipVideoContainer() {

        mVipWebList.add(new VipWeb(getResources().getDrawable(R.mipmap.tengxun), "腾讯视频", "https://m.v.qq.com/"));
        mVipWebList.add(new VipWeb(getResources().getDrawable(R.mipmap.iqiyi), "爱奇艺视频", "https://m.iqiyi.com/vip"));
        mVipWebList.add(new VipWeb(getResources().getDrawable(R.mipmap.youku), "优酷视频", "http://youku.com/"));
        mVipWebList.add(new VipWeb(getResources().getDrawable(R.mipmap.sohu), "搜狐视频", "https://m.tv.sohu.com/film"));
        mVipWebList.add(new VipWeb(getResources().getDrawable(R.mipmap.mgtv), "芒果视频", "https://m.mgtv.com/channel/979"));
        mVipWebList.add(new VipWeb(getResources().getDrawable(R.mipmap.letv), "乐视视频", "https://m.le.com/vip"));
        mVipWebList.add(new VipWeb(getResources().getDrawable(R.mipmap.fengxing), "风行视频", "http://m.fun.tv/"));
        mVipWebList.add(new VipWeb(getResources().getDrawable(R.mipmap.pptv), "PP视频", "http://m.pptv.com"));

        vipvideo_container.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        RecyclerAdapter mRecyclerAdapter = new RecyclerAdapter(getActivity()) {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(getActivity()).inflate(R.layout.vipvideo_item, parent, false);
                return new VipVideoViewHolder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

                final VipWeb item = (VipWeb) getDataSource().get(position);
                if (holder instanceof VipVideoViewHolder) {
                    VipVideoViewHolder vipVideoViewHolder = (VipVideoViewHolder) holder;
                    vipVideoViewHolder.logoImg.setImageDrawable(item.getLogoImg());
                    vipVideoViewHolder.titleTxt.setText(item.getName());
                    vipVideoViewHolder.item_container.setClickable(true);
                    vipVideoViewHolder.item_container.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent mIntent = new Intent();
                            mIntent.setData(Uri.parse(item.getVideoUrl()));
                            mIntent.setClass(getActivity(), VideoBrowserActivity.class);
                            startActivity(mIntent);
                        }
                    });
                }

            }
        };

        mRecyclerAdapter.setData(mVipWebList);
        vipvideo_container.setAdapter(mRecyclerAdapter);

    }

    private void initOtherVideoContainer() {

        mOtherWebList.add(new VipWeb(getResources().getDrawable(R.mipmap.renrenys), "人人影视", "http://www.rryy99.com/?tdsourcetag=s_pctim_aiomsg"));
        mOtherWebList.add(new VipWeb(getResources().getDrawable(R.mipmap.meiju), "美剧大片", "https://lvnvl.cn/"));
        mOtherWebList.add(new VipWeb(getResources().getDrawable(R.mipmap.wuaiys), "吾爱影视", "http://52online.vip/"));
        mOtherWebList.add(new VipWeb(getResources().getDrawable(R.mipmap.tiantian_movie), "天天影视", "http://m.kankan.com/"));

        othervideo_container.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        RecyclerAdapter mRecyclerAdapter = new RecyclerAdapter(getActivity()) {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(getActivity()).inflate(R.layout.vipvideo_item, parent, false);
                return new VipVideoViewHolder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

                final VipWeb item = (VipWeb) getDataSource().get(position);
                if (holder instanceof VipVideoViewHolder) {
                    VipVideoViewHolder vipVideoViewHolder = (VipVideoViewHolder) holder;
                    vipVideoViewHolder.logoImg.setImageDrawable(item.getLogoImg());
                    vipVideoViewHolder.titleTxt.setText(item.getName());
                    vipVideoViewHolder.item_container.setClickable(true);
                    vipVideoViewHolder.item_container.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent mIntent = new Intent();
                            mIntent.setData(Uri.parse(item.getVideoUrl()));
                            mIntent.setClass(getActivity(), BrowserActivity.class);
                            startActivity(mIntent);
                        }
                    });
                }

            }
        };

        mRecyclerAdapter.setData(mOtherWebList);
        othervideo_container.setAdapter(mRecyclerAdapter);

    }

    public static VipVideo_Frame_Fragment newInstance() {
        return new VipVideo_Frame_Fragment();
    }
}
