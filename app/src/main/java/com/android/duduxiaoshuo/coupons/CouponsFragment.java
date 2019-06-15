package com.android.duduxiaoshuo.coupons;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.android.duduxiaoshuo.R;
import com.android.duduxiaoshuo.config.Commonconfig;
import com.android.duduxiaoshuo.webs.BrowserActivity;
import com.android.duduxiaoshuo.webs.X5WebView;
import com.android.fastapp.xdroidmvp.mvp.XLazyFragment;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

public class CouponsFragment extends XLazyFragment {


    @BindView(R.id.x5WebView)
    X5WebView mX5WebView;

    @Override
    public void initData(Bundle savedInstanceState) {

        mX5WebView.loadUrl(Commonconfig.COUPONS_URL);

        mX5WebView.setWebViewClient(new WebViewClient(){

            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                Log.i("dqqqq","BrowserActivity   url="+url);
                if(url != null && url.equals(Commonconfig.COUPONS_URL)){
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
        return R.layout.layout_couponsframe;
    }

    @Override
    public Object newP() {
        return null;
    }

    public static CouponsFragment newInstance(){
        return new CouponsFragment();
    }
}
