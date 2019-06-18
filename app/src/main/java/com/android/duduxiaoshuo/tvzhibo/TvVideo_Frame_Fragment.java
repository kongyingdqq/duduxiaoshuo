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
import com.android.duduxiaoshuo.tvzhibo.model.TvOnlineData;
import com.android.duduxiaoshuo.tvzhibo.model.VipVideoViewHolder;
import com.android.duduxiaoshuo.tvzhibo.model.VipWeb;
import com.android.duduxiaoshuo.webs.TvOnlineBrowserActivity;
import com.android.duduxiaoshuo.webs.VideoBrowserActivity;
import com.android.fastapp.xdroidmvp.mvp.XLazyFragment;
import com.tencent.smtt.sdk.TbsVideo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.droidlover.xrecyclerview.RecyclerAdapter;
import cn.droidlover.xrecyclerview.XRecyclerView;

public class TvVideo_Frame_Fragment extends XLazyFragment {

    @BindView(R.id.tvonline_container)
    XRecyclerView tvonline_container;


    private List<TvOnlineData> mTvOnlineList = new ArrayList<>();

    @Override
    public void initData(Bundle savedInstanceState) {

        initTvOnline();

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_tvvideo_frame;
    }

    @Override
    public Object newP() {
        return null;
    }

    private void initTvOnline() {

        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1), "中央1台", "http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv2), "中央2台", "http://ivi.bupt.edu.cn/hls/cctv2.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv3), "中央3台", "http://ivi.bupt.edu.cn/hls/cctv3hd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv4), "中央4台", "http://ivi.bupt.edu.cn/hls/cctv4.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv5), "中央5台", "http://ivi.bupt.edu.cn/hls/cctv5hd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv6), "中央6台", "http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv7), "中央7台", "http://ivi.bupt.edu.cn/hls/cctv7.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv8), "中央8台", "http://ivi.bupt.edu.cn/hls/cctv8hd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv9), "中央9台", "http://ivi.bupt.edu.cn/hls/cctv9.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv10), "中央10台", "http://ivi.bupt.edu.cn/hls/cctv10.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv11), "中央11台", "http://ivi.bupt.edu.cn/hls/cctv11.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv12), "中央12台", "http://ivi.bupt.edu.cn/hls/cctv12.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv13), "中央13台", "http://ivi.bupt.edu.cn/hls/cctv13.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv14), "中央14台", "http://ivi.bupt.edu.cn/hls/cctv14.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv5_1),"体育赛事","http://ivi.bupt.edu.cn/hls/cctv5phd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"湖南卫视","http://ivi.bupt.edu.cn/hls/hunanhd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"东方卫视","http://ivi.bupt.edu.cn/hls/dfhd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"云南卫视","http://ivi.bupt.edu.cn/hls/yntv.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"内蒙古卫视","http://ivi.bupt.edu.cn/hls/nmtv.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"北京体育","http://ivi.bupt.edu.cn/hls/btv6hd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"北京少儿","http://ivi.bupt.edu.cn/hls/btv10.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"厦门卫视","http://ivi.bupt.edu.cn/hls/jstv.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"四川卫视","http://ivi.bupt.edu.cn/hls/sctv.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"天津卫视","http://ivi.bupt.edu.cn/hls/tjhd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"宁夏卫视","http://ivi.bupt.edu.cn/hls/nxtv.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"安徽卫视","http://ivi.bupt.edu.cn/hls/ahhd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"山东卫视","http://ivi.bupt.edu.cn/hls/sdhd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"山西卫视","http://ivi.bupt.edu.cn/hls/sxrtv.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"广东卫视","http://ivi.bupt.edu.cn/hls/gdhd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"广西卫视","http://ivi.bupt.edu.cn/hls/gxtv.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"江苏卫视","http://ivi.bupt.edu.cn/hls/jshd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"江西卫视","http://ivi.bupt.edu.cn/hls/jxtv.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"河北卫视","http://ivi.bupt.edu.cn/hls/hebtv.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"河南卫视","http://ivi.bupt.edu.cn/hls/hntv.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"深圳卫视","http://ivi.bupt.edu.cn/hls/szhd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"湖北卫视","http://ivi.bupt.edu.cn/hls/hbhd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"甘肃卫视","http://ivi.bupt.edu.cn/hls/gstv.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"东南卫视","http://ivi.bupt.edu.cn/hls/dntv.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"翡翠卫视","http://acm.gg/jade.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"贵州卫视","http://ivi.bupt.edu.cn/hls/gztv.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"辽宁卫视","http://ivi.bupt.edu.cn/hls/lnhd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"重庆卫视","http://ivi.bupt.edu.cn/hls/cqhd.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"青海卫视","http://ivi.bupt.edu.cn/hls/gxtv.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"香港卫视","http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8"));
        mTvOnlineList.add(new TvOnlineData(getResources().getDrawable(R.mipmap.cctv1),"黑龙江卫视","http://ivi.bupt.edu.cn/hls/hljhd.m3u8"));



        tvonline_container.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        RecyclerAdapter mRecyclerAdapter = new RecyclerAdapter(getActivity()) {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(getActivity()).inflate(R.layout.tvonline_item, parent, false);
                return new VipVideoViewHolder(view);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

                final TvOnlineData item = (TvOnlineData) getDataSource().get(position);
                if (holder instanceof VipVideoViewHolder) {
                    VipVideoViewHolder vipVideoViewHolder = (VipVideoViewHolder) holder;
                    vipVideoViewHolder.logoImg.setImageDrawable(item.getLogoImg());
                    vipVideoViewHolder.titleTxt.setText(item.getName());
                    vipVideoViewHolder.item_container.setClickable(true);
                    vipVideoViewHolder.item_container.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (true) {
                                Intent mIntent = new Intent();
                                mIntent.setData(Uri.parse(item.getOnlineUrl()));
                                mIntent.setClass(getActivity(), TvOnlineBrowserActivity.class);
                                startActivity(mIntent);
                            } else {
                                //视频播放器播放
                                TbsVideo.openVideo(getActivity(), item.getOnlineUrl());
                            }
                        }
                    });
                }

            }
        };

        mRecyclerAdapter.setData(mTvOnlineList);
        tvonline_container.setAdapter(mRecyclerAdapter);

    }

    public static TvVideo_Frame_Fragment newInstance() {
        return new TvVideo_Frame_Fragment();
    }
}
