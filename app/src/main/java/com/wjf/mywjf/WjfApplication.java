package com.wjf.mywjf;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/10/20.
 */
public class WjfApplication extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
