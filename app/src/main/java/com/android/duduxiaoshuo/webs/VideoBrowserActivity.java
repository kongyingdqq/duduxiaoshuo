package com.android.duduxiaoshuo.webs;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.duduxiaoshuo.R;
import com.android.duduxiaoshuo.mainpannel.BaseActivity;
import com.android.duduxiaoshuo.tvzhibo.VipVideo_Play;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

import static com.android.duduxiaoshuo.R.drawable.top_background;

public class VideoBrowserActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "VideoBrowserActivity";
    private Context context;
    @BindView(R.id.x5WebView)
    X5WebView mX5WebView;
    @BindView(R.id.video_start)
    TextView videoStart;
    @BindView(R.id.video_close)
    TextView videoClose;

//    @BindView(R.id.vipvideo_playcontainer)
//    LinearLayout vipvideo_playcontainer;
//
//    @BindView(R.id.vipvideo_play_webview)
//    X5WebView vipvideo_play_webview;
//
//    @BindView(R.id.vipvideo_play_tips)
//    TextView vipvideo_play_tips;

    String mIntentUrl, vipvideo_initurl;

    String jiexiUrl = "http://ka61b.cn/jx.php?url=";
    String emptyHtml = "file:///android_asset/webpage/waitforloading.html";

    @SuppressLint("ResourceType")
    @Override
    public void initData(Bundle savedInstanceState) {
        Intent intent = getIntent();
        context = getBaseContext();
        if (intent != null && intent.getData() != null) {
            mIntentUrl = intent.getData().toString();
            Log.i("dqqqq", "BrowserActivity   mIntentUrl=" + mIntentUrl);
            if (mIntentUrl != null) {
                mX5WebView.loadUrl(mIntentUrl);
                initVideo();
            }
        } else {
            finish();
        }

    }

    private void initVideo() {
        videoStart.setOnClickListener(this);
        videoClose.setOnClickListener(this);

    }

    @Override
    public int getLayoutId() {
        return R.layout.vipvideo_browser_layout;
    }

    @Override
    public Object newP() {
        return null;
    }

    @Override
    public void onBackPressed() {

//        if (vipvideo_playcontainer != null && vipvideo_playcontainer.isShown()) {
//            vipvideo_playcontainer.setVisibility(View.GONE);
//            vipvideo_play_webview.loadUrl(emptyHtml);
//            return;
//        }

        if (mX5WebView != null && mX5WebView.canGoBack()) {
            mX5WebView.goBack();
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.video_start:
                String url = mX5WebView.getUrl();
                Intent intent = new Intent(this, VipVideo_Play.class);
                intent.putExtra("URL",url);
                startActivity(intent);
                break;
            case R.id.video_close:
                finish();
                break;
        }
    }
}
