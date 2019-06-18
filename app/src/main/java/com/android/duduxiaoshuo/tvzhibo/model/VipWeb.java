package com.android.duduxiaoshuo.tvzhibo.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class VipWeb implements Serializable {
    Drawable logoImg;
    String name;
    String videoUrl;

    private void VipWeb(){

    }

    public VipWeb(Drawable logoImg, String name, String videoUrl) {
        this.logoImg = logoImg;
        this.name = name;
        this.videoUrl = videoUrl;
    }

    public Drawable getLogoImg() {
        return logoImg;
    }

    public String getName() {
        return name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

}
