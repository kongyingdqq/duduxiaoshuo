package com.android.duduxiaoshuo.webs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.android.duduxiaoshuo.R;
import com.android.duduxiaoshuo.config.Commonconfig;
import com.android.duduxiaoshuo.mainpannel.BaseActivity;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

public class BrowserActivity extends BaseActivity {

	@BindView(R.id.x5WebView)
	X5WebView mX5WebView;
	String mIntentUrl;

	@Override
	public void initData(Bundle savedInstanceState) {
		Intent intent = getIntent();
		if (intent != null && intent.getData() != null) {
			mIntentUrl = intent.getData().toString();
			if(mIntentUrl != null){
				mX5WebView.loadUrl(mIntentUrl);
			}
		}else {
			finish();
		}
		mX5WebView.setWebViewClient(new WebViewClient(){

			public boolean shouldOverrideUrlLoading(WebView view, String url) {


				//if(url != null && (url.startsWith("http") ||(url.startsWith("http2"))))
				{
					view.loadUrl(url);
				}
				return true;
			}
		});

	}

	@Override
	public int getLayoutId() {
		return R.layout.layout_browseractivity;
	}

	@Override
	public Object newP() {
		return null;
	}

	@Override
	public void onBackPressed() {
		if(mX5WebView != null && mX5WebView.canGoBack()){
			mX5WebView.goBack();
			return;
		}
		super.onBackPressed();
	}
}
