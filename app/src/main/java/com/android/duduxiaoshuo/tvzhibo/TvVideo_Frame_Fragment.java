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
import com.android.duduxiaoshuo.webs.VideoBrowserActivity;
import com.android.fastapp.xdroidmvp.mvp.XLazyFragment;

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
                            Intent mIntent = new Intent();
                            mIntent.setData(Uri.parse(item.getOnlineUrl()));
                            mIntent.setClass(getActivity(), VideoBrowserActivity.class);
                            startActivity(mIntent);
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
