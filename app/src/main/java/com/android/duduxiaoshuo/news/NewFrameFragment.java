package com.android.duduxiaoshuo.news;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.android.duduxiaoshuo.R;
import com.android.duduxiaoshuo.config.Commonconfig;
import com.android.duduxiaoshuo.webs.BrowserActivity;
import com.android.duduxiaoshuo.webs.X5WebView;
import com.android.fastapp.xdroidmvp.mvp.XLazyFragment;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

public class NewFrameFragment extends XLazyFragment {


    @BindView(R.id.x5WebView)
    X5WebView mX5WebView;

    @Override
    public void initData(Bundle savedInstanceState) {

        mX5WebView.loadUrl(Commonconfig.TELENT_NEWS_URL);

        mX5WebView.setWebViewClient(new WebViewClient(){

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url != null && url.equals(Commonconfig.TELENT_NEWS_URL)){
                    view.loadUrl(url);
                }else {

                     Intent mIntent = new Intent();
                     mIntent.setData(Uri.parse(url));
                     mIntent.setClass(getActivity(), BrowserActivity.class);
                     startActivity(mIntent);
                }
                return true;
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_newsframe;
    }

    @Override
    public Object newP() {
        return null;
    }

    public static NewFrameFragment newInstance(){
        return new NewFrameFragment();
    }


}
