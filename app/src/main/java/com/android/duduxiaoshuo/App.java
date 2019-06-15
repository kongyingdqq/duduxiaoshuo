package com.android.duduxiaoshuo;

import android.app.Application;
import android.content.Context;

import com.android.fastapp.xdroidmvp.net.NetError;
import com.android.fastapp.xdroidmvp.net.NetProvider;
import com.android.fastapp.xdroidmvp.net.RequestHandler;
import com.android.fastapp.xdroidmvp.net.XApi;

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

    }

    public static Context getContext() {
        return context;
    }
}