package com.android.duduxiaoshuo;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.fastapp.xdroidmvp.net.NetError;
import com.android.fastapp.xdroidmvp.net.NetProvider;
import com.android.fastapp.xdroidmvp.net.RequestHandler;
import com.android.fastapp.xdroidmvp.net.XApi;
import com.tencent.smtt.sdk.QbSdk;

import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

public class App extends Application {

    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        XApi.registerProvider(new NetProvider() {
            @Override
            public Interceptor[] configInterceptors() {
                return new Interceptor[0];
            }

            @Override
            public void configHttps(OkHttpClient.Builder builder) {

            }

            @Override
            public CookieJar configCookie() {
                return null;
            }

            @Override
            public RequestHandler configHandler() {
                return null;
            }

            @Override
            public long configConnectTimeoutMills() {
                return 0;
            }

            @Override
            public long configReadTimeoutMills() {
                return 0;
            }

            @Override
            public boolean configLogEnable() {
                return true;
            }

            @Override
            public boolean handleError(NetError error) {
                return false;
            }

            @Override
            public boolean dispatchProgressEnable() {
                return false;
            }
        });

        initX5videoPlay();

    }

    public static Context getContext() {
        return context;
    }


    private void initX5videoPlay(){
        //回调接口初始化完成接口回调
        QbSdk.PreInitCallback pcb=new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {

            }
            @Override
            public void onViewInitFinished(boolean b) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.e("myApplication", " x5内核加载成功？" + b);
            }
        };

        //x5内核预加载，异步初始化x5 webview所需环境
        QbSdk.initX5Environment(getApplicationContext(), pcb);
    }
}
