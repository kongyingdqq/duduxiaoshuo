package com.android.duduxiaoshuo.tvzhibo.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class TvOnlineData implements Serializable {
    Drawable logoImg;
    String name;
    String onlineUrl;

    private void TvOnlineData() {

    }

    public TvOnlineData(Drawable logoImg, String name, String onlineUrl) {
        this.logoImg = logoImg;
        this.name = name;
        this.onlineUrl = onlineUrl;
    }

    public Drawable getLogoImg() {
        return logoImg;
    }

    public String getName() {
        return name;
    }

    public String getOnlineUrl() {
        return onlineUrl;
    }

}
