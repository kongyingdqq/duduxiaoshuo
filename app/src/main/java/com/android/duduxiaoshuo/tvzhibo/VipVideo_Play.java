package com.android.duduxiaoshuo.tvzhibo;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.duduxiaoshuo.R;
import com.android.duduxiaoshuo.coupons.CouponsActivity;
import com.android.duduxiaoshuo.mainpannel.BaseActivity;
import com.android.duduxiaoshuo.webs.X5WebView;


import butterknife.BindView;

public class VipVideo_Play extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.x5WebView)
    X5WebView mX5WebView;
    @BindView(R.id.replace_line)
    TextView replaceLine;
    @BindView(R.id.refresh)
    TextView refresh;
    @BindView(R.id.advertising_image)
    ImageView advertisingImage;

    private String url;
    private static final String TAG = "VipVideo_Play";

    private SharedPreferences data;
    @Override
    public void initData(Bundle savedInstanceState) {
        data = context.getSharedPreferences("data", MODE_PRIVATE);
        String urll = data.getString("urll", null);
        Intent intent = getIntent();
        url = intent.getStringExtra("URL");
        mX5WebView.loadUrl(urll + url);
        replaceLine.setOnClickListener(this);
        refresh.setOnClickListener(this);
        advertisingImage.setOnClickListener(this);
    }
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    String urll = data.getString("urll", null);
                    mX5WebView.loadUrl(urll + url);
                    break;
                case 2:
                    String url2 = data.getString("url2", null);
                    mX5WebView.loadUrl(url2 + url);
                    break;
                case 3:
                    String url3 = data.getString("url3", null);
                    mX5WebView.loadUrl(url3 + url);
                    break;
            }
        }
    };
    @Override
    public int getLayoutId() {
        return R.layout.activity_vip_video_play;
    }

    @Override
    public Object newP() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.replace_line:
                showBottomDialog();
                break;
            case R.id.refresh:
                String urll = data.getString("urll", null);
                mX5WebView.loadUrl(urll + url);
                break;
            case R.id.advertising_image:
                Intent intent = new Intent(this, CouponsActivity.class);
                context.startActivity(intent);

                break;
        }
    }

    private void showBottomDialog(){
        //1、使用Dialog、设置style
        final Dialog dialog = new Dialog(this,R.style.DialogTheme);
        //2、设置布局
        View view = View.inflate(this,R.layout.dialog_replaceline_layout,null);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        //设置弹出位置
        window.setGravity(Gravity.BOTTOM);
        //设置弹出动画
        window.setWindowAnimations(R.style.main_menu_animStyle);
        //设置对话框大小
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        dialog.findViewById(R.id.vip_line_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.vip_line_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message message = new Message();
                message.what = 2;
                handler.sendMessage(message);
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.vip_line_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message message = new Message();
                message.what = 3;
                handler.sendMessage(message);
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }
}
