package com.android.duduxiaoshuo.mainpannel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.duduxiaoshuo.R;
import com.android.duduxiaoshuo.coupons.CouponsFragment;
import com.android.duduxiaoshuo.me.MeFragment;
import com.android.duduxiaoshuo.news.NewFrameFragment;
import com.android.duduxiaoshuo.tvzhibo.TvzhiboFrameFragment;
import com.android.duduxiaoshuo.xiaoshuo.XiaoshuoFrameFragment;
import com.android.fastapp.xdroidmvp.base.XFragmentAdapter;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.othershe.dutil.DUtil;
import com.othershe.dutil.callback.DownloadCallback;
import com.tmall.ultraviewpager.UltraViewPager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_commontablelayout)
    CommonTabLayout mCommonTabLayout;

    @BindView(R.id.ultraviewpager_page_container)
    UltraViewPager mUltraViewPager;
    XFragmentAdapter mUltraViewPagerAdapter;


    ArrayList<CustomTabEntity> mCustomTabEntityList = new ArrayList<>();
    ArrayList<Fragment> mXLazyFragmentList = new ArrayList<>();
    private String version = "0.0.2";
    private static final String TAG = "MainActivity";
    private Context context;
    private Button startDownload;
    private String updataLink;
    private ProgressBar progressBar;

    @Override
    public void initData(Bundle savedInstanceState) {
        context = getBaseContext();
        initCommonTabLayout();
        initViewpager();
        getJosn();
    }
    private void getJosn() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();

                Request request = new Request.Builder()
                        .url("http://106.12.136.25:88/login/login/imei.html?uid=521").build();
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    String date = response.body().string();
                    Log.i(TAG, "run: date:"+date);
                    jsonJX(date);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void jsonJX(String date) {
        if (date != null) {
            try {
                JSONObject jsonObject = new JSONObject(date);
                String code = jsonObject.getString("code");
                if (code.equals("1")) {
                    JSONObject msg = jsonObject.getJSONObject("msg");
                    String urll = msg.getString("url2");
                    String url2 = msg.getString("url3");
                    String url3 = msg.getString("url4");
                    String advert = msg.getString("advert");
                    Boolean update = msg.getBoolean("url8");
                    String newVersion = msg.getString("url9");
                    updataLink = msg.getString("url10");
                    SharedPreferences data = context.getSharedPreferences("data", MODE_PRIVATE);
                    SharedPreferences.Editor edit = data.edit();
                    edit.putString("urll",urll);
                    edit.putString("url2",url2);
                    edit.putString("url3",url3);
                    edit.putString("advert",advert);
                    edit.apply();
                    int isNewVersion = compareVersion(newVersion,version);
                    if (isNewVersion == 1 && update && updataLink.length() != 0) {
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putString("link",updataLink);
                        message.setData(bundle);
                        message.what = 100;
                        handler.sendMessage(message);
                    }
                } else {
                    Toast.makeText(context, R.string.check_network, Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 100:
                    isUpdata();
                    break;
            }
        }
    };

    private void isUpdata() {
        View view = getLayoutInflater().inflate(R.layout.updata_layout, null);
        CustomDialog customDialog = new CustomDialog(this, 0, 0, view, R.style.SettingsDialogStyle);
        startDownload = view.findViewById(R.id.start_download);
        progressBar = view.findViewById(R.id.pb_main_download);
        startDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.lanzous.com/i9tu7za");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                /*DUtil.init(context)
                        .url(updataLink)
                        .path(Environment.getExternalStorageDirectory() + "/YouYY/")
                        .name("youyy.apk")
                        .childTaskCount(3)
                        .build()
                        .start(new DownloadCallback() {
                            @Override
                            public void onStart(long l, long l1, float v) {
                                Toast.makeText(context, "开始下载", Toast.LENGTH_SHORT).show();
                                startDownload.setEnabled(false);
                                startDownload.setText("正在下载");
                            }
                            @Override
                            public void onProgress(long currentSize, long totalSize, float progress) {
                                progressBar.setProgress((int) progress);
                            }

                            @Override
                            public void onPause() {

                            }

                            @Override
                            public void onCancel() {

                            }

                            @Override
                            public void onFinish(File file) {
                                Toast.makeText(context, "下载完成", Toast.LENGTH_SHORT).show();
                                String fileName = Environment.getExternalStorageDirectory() + "/YouYY/youyy.apk";
                                Intent i = new Intent();
                                i.setAction(Intent.ACTION_VIEW);
                                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                i.setDataAndType(Uri.fromFile(new File(fileName) ), "application/vnd.android.package-archive");
                                startActivity(i);
                            }

                            @Override
                            public void onWait() {

                            }

                            @Override
                            public void onError(String s) {
                                Toast.makeText(context, "下载出错，请重启软件", Toast.LENGTH_SHORT).show();
                                String fileName = Environment.getExternalStorageDirectory() + "/YouYY/";
                                deleteFolder(fileName);
                            }
                        });*/

            }
        });
        customDialog.setCanceledOnTouchOutside(false);
        customDialog.show();
    }
    public void deleteFolder(String filePath){
        File deleteFile = new File(filePath);
        if (deleteFile.isDirectory()){
            File[] listFiles = deleteFile.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                deleteFile.delete();
            }else {
                for (File f : listFiles){
                    f.delete();
                }
                deleteFile.delete();
            }
        }
    }


    /**
     * 版本号比较
     * compareTo()方法返回值为int类型，就是比较两个值，如：x.compareTo(y)。如果前者大于后者，返回1，前者等于后者则返回0，前者小于后者则返回-1
     * @param s1
     * @param s2
     * @return 范围可以是"2.20.", "2.10.0"  ,".20","2.10.0",2.1.3 ，3.7.5，10.2.0
     */
    public static int compareVersion(String s1, String s2) {
        String[] s1Split = s1.split("\\.", -1);
        String[] s2Split = s2.split("\\.", -1);
        int len1 = s1Split.length;
        int len2 = s2Split.length;
        int lim = Math.min(len1, len2);
        int i = 0;
        while (i < lim) {
            int c1 = "".equals(s1Split[i]) ? 0 : Integer.parseInt(s1Split[i]);
            int c2 = "".equals(s2Split[i]) ? 0 : Integer.parseInt(s2Split[i]);
            if (c1 != c2) {
                return c1 - c2;
            }
            i++;
        }
        return len1 - len2;
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Object newP() {
        return null;
    }


    private void initCommonTabLayout(){
//        mCustomTabEntityList.add(new TabEntityBean(getString(R.string.title_xiaoshuo),
//                R.drawable.vector_drawable_xiaoshuo_focus,R.drawable.vector_drawable_xiaoshuo_unfocus));
        mCustomTabEntityList.add(new TabEntityBean(getString(R.string.title_vipshipin),
                R.drawable.vector_drawable_vipvideo_focus,R.drawable.vector_drawable_vipvideo_unfocus));
        mCustomTabEntityList.add(new TabEntityBean(getString(R.string.title_youhuijuan),
                R.drawable.vector_drawable_youhuijuan_focus,R.drawable.vector_drawable_youhuijuan_unfocus));
        mCustomTabEntityList.add(new TabEntityBean(getString(R.string.title_news),
                R.drawable.vector_drawable_news_focus,R.drawable.vector_drawable_news_unfocus));
//        mCustomTabEntityList.add(new TabEntityBean(getString(R.string.title_me),
//                R.drawable.vector_drawable_wode_focus,R.drawable.vector_drawable_wode_unfocus));

        mCommonTabLayout.setTabData(mCustomTabEntityList);
        mCommonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mUltraViewPager.setCurrentItem(position,true);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    private void initViewpager(){
        //小説頁面
        //mXLazyFragmentList.add(XiaoshuoFrameFragment.newInstance());
        mXLazyFragmentList.add(TvzhiboFrameFragment.newInstance());
        mXLazyFragmentList.add(CouponsFragment.newInstance());
        mXLazyFragmentList.add(NewFrameFragment.newInstance());
        //mXLazyFragmentList.add(MeFragment.newInstance());

        String[] fragment_title ={getString(R.string.title_xiaoshuo),getString(R.string.title_vipshipin),getString(R.string.title_news),
                getString(R.string.title_youhuijuan),getString(R.string.title_me)};

        mUltraViewPagerAdapter = new XFragmentAdapter(getSupportFragmentManager(),mXLazyFragmentList,fragment_title);
        mUltraViewPager.setAdapter(mUltraViewPagerAdapter);
        mUltraViewPager.setOffscreenPageLimit(fragment_title.length);
        mUltraViewPager.setDisableSlide(true);

        mUltraViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCommonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        if(mCommonTabLayout != null && mCommonTabLayout.getCurrentTab() == 2){

        }
        super.onBackPressed();
    }
}
