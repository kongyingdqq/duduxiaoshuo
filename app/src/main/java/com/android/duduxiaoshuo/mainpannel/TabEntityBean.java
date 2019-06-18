package com.android.duduxiaoshuo.mainpannel;

import com.flyco.tablayout.listener.CustomTabEntity;

import java.io.Serializable;

public class TabEntityBean implements CustomTabEntity , Serializable {

    String mtitle;
    int selectdicon;
    int unselecticon;

    public TabEntityBean(String mtitle, int selectdicon, int unselecticon) {
        this.mtitle = mtitle;
        this.selectdicon = selectdicon;
        this.unselecticon = unselecticon;
    }

    @Override
    public String getTabTitle() {
        return mtitle;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectdicon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unselecticon;
    }
}
