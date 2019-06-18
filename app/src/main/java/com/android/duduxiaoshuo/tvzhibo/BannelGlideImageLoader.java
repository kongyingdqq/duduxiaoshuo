package com.android.duduxiaoshuo.tvzhibo;

import android.content.Context;
import android.widget.ImageView;

import com.android.duduxiaoshuo.view.RoundAngleImageView;
import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

public class BannelGlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);
    }

    @Override
    public ImageView createImageView(Context context) {
        //圆角
        return new RoundAngleImageView(context);
    }
}
