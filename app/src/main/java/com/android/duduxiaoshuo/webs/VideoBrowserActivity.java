package com.android.duduxiaoshuo.webs;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.duduxiaoshuo.R;
import com.android.duduxiaoshuo.mainpannel.BaseActivity;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

public class VideoBrowserActivity extends BaseActivity {

    @BindView(R.id.x5WebView)
    X5WebView mX5WebView;

    @BindView(R.id.vipvideo_playcontainer)
    LinearLayout vipvideo_playcontainer;

    @BindView(R.id.vipvideo_play_webview)
    X5WebView vipvideo_play_webview;

    @BindView(R.id.vipvideo_play_tips)
    TextView vipvideo_play_tips;

    String mIntentUrl, vipvideo_initurl;

    String jiexiUrl = "http://ka61b.cn/jx.php?url=";
    String emptyHtml = "file:///android_asset/webpage/waitforloading.html";

    @Override
    public void initData(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent != null && intent.getData() != null) {
            mIntentUrl = intent.getData().toString();
            Log.i("dqqqq", "BrowserActivity   mIntentUrl=" + mIntentUrl);
            if (mIntentUrl != null) {
                mX5WebView.loadUrl(mIntentUrl);
            }
        } else {
            finish();
        }

        // set init show state.
        vipvideo_playcontainer.setVisibility(View.INVISIBLE);
        vipvideo_play_webview.setVisibility(View.GONE);
        vipvideo_play_tips.setVisibility(View.VISIBLE);

        vipvideo_playcontainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vipvideo_playcontainer.setVisibility(View.VISIBLE);
                vipvideo_play_tips.setVisibility(View.GONE);
                vipvideo_play_webview.setVisibility(View.VISIBLE);
                vipvideo_play_webview.loadUrl(jiexiUrl + vipvideo_initurl);

                Log.i("dqqqq", "onclick   jiexiUrl=" + (jiexiUrl + vipvideo_initurl));
            }
        });

        mX5WebView.setWebViewClient(new WebViewClient() {

            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                Log.i("dqqqq", "VideoBrowserActivity   url=" + url);
                if (url != null && (url.startsWith("http") || (url.startsWith("http2")))) {
                    view.loadUrl(url);
                }
                //telent
                if (url.startsWith("https://m.v.qq.com/play.html") //telent
                        || url.startsWith("https://m.v.qq.com/cover")
                        ||url.startsWith("https://m.iqiyi.com/v_")//iqiyi
                        ||url.startsWith("https://m.youku.com/video/id_")//youku
                        ||(url.startsWith("https://m.tv.sohu.com/v")&&url.contains(".shtml")&&url.contains("channeled"))//souhu
                        ||(url.startsWith("https://m.mgtv.com/b/") && url.contains(".html")) //mangguotv
                        ||(url.startsWith("https://m.le.com/vplay") && url.contains(".html")) //le
                        /*||(url.startsWith("http://m.fun.tv/mplay/?mid"))*/ //fun
                        ||(url.startsWith("https://m.pptv.com/show/") && url.contains(".html"))

                    ) {
                    vipvideo_playcontainer.setVisibility(View.VISIBLE);
                    vipvideo_play_tips.setVisibility(View.VISIBLE);
                    vipvideo_play_webview.setVisibility(View.GONE);
                    vipvideo_initurl = url;
                    vipvideo_play_webview.loadUrl(emptyHtml);

                }
                return true;
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {


                return super.shouldInterceptRequest(webView, url);


            }
        });

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

        if (vipvideo_playcontainer != null && vipvideo_playcontainer.isShown()) {
            vipvideo_playcontainer.setVisibility(View.GONE);
            vipvideo_play_webview.loadUrl(emptyHtml);
            return;
        }

        if (mX5WebView != null && mX5WebView.canGoBack()) {
            mX5WebView.goBack();
            return;
        }
        super.onBackPressed();
    }
}
