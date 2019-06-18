package com.android.duduxiaoshuo.tvzhibo.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.duduxiaoshuo.R;

public class VipVideoViewHolder extends RecyclerView.ViewHolder {

    public LinearLayout item_container;
    public ImageView logoImg;
    public TextView titleTxt;

    public VipVideoViewHolder(View itemView) {
        super(itemView);
        logoImg = itemView.findViewById(R.id.logoImg);
        titleTxt = itemView.findViewById(R.id.titleTxt);
        item_container = itemView.findViewById(R.id.item_container);
    }
}
