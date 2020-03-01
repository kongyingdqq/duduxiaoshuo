package com.android.duduxiaoshuo.coupons;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.duduxiaoshuo.R;
import com.android.duduxiaoshuo.config.Commonconfig;
import com.android.duduxiaoshuo.webs.BrowserActivity;
import com.android.duduxiaoshuo.webs.X5WebView;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class CouponsActivity extends AppCompatActivity {
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);
        context = getBaseContext();
        X5WebView x5WebView = findViewById(R.id.x5WebView);

        x5WebView.loadUrl(Commonconfig.COUPONS_LIST_URL);

        x5WebView.setWebViewClient(new WebViewClient(){

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url != null && url.equals(Commonconfig.COUPONS_LIST_URL)){
                    view.loadUrl(url);
                }
                return true;
            }
        });
        Toast.makeText(context, "请复制口令购买", Toast.LENGTH_SHORT).show();
    }
}
