package com.android.duduxiaoshuo.mainpannel;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class CustomDialog extends Dialog {

    public CustomDialog(@NonNull Context context, int weidth, int height, View layout,int themeResId) {
        super(context, themeResId);
        setContentView(layout);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = Gravity.CENTER;
        window.setAttributes(attributes);
    }
}
