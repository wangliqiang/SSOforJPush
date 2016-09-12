package com.sso.application;

import android.app.Application;

import com.sso.utils.Log;

import cn.jpush.android.api.JPushInterface;

/**
 * @author 王立强
 * @Date 2016/7/29.
 */
public class MyApplication extends Application {
    private static final String TAG = "JPush";

    @Override
    public void onCreate() {
        Log.d(TAG, "[ExampleApplication] onCreate");
        super.onCreate();

        JPushInterface.setDebugMode(true); 	// 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);     		// 初始化 JPush
    }
}
