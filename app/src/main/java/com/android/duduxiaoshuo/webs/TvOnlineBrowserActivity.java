package com.android.duduxiaoshuo.webs;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.duduxiaoshuo.R;
import com.android.duduxiaoshuo.mainpannel.BaseActivity;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

public class TvOnlineBrowserActivity extends BaseActivity {

	@BindView(R.id.x5WebView)
	X5WebView mX5WebView;
	String mIntentUrl;

	@Override
	public void initData(Bundle savedInstanceState) {
		Intent intent = getIntent();
		if (intent != null && intent.getData() != null) {
			mIntentUrl = intent.getData().toString();
			Log.i("dqqqq","BrowserActivity   mIntentUrl="+mIntentUrl);
			if(mIntentUrl != null){
				mX5WebView.loadUrl(mIntentUrl);
			}
		}else {
			finish();
		}
		mX5WebView.setWebViewClient(new WebViewClient(){

			public boolean shouldOverrideUrlLoading(WebView view, String url) {

				Log.i("dqqqq","TvOnlineBrowserActivity   url="+url);
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

		Log.i("dqqqq","getLayoutId  ######### ");
		return R.layout.layout_tvonline_browseractivity;
	}

	@Override
	public Object newP() {
		return null;
	}


	@Override
	protected void onStart() {
		super.onStart();
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
