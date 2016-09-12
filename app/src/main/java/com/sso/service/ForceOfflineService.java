package com.sso.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import com.sso.receiver.ForceOfflineReceiver;
import com.sso.utils.Log;

/**
 * @author 王立强
 * @Date 2016/7/29.
 */
public class ForceOfflineService extends Service {

    private static final String TAG = "ForceOfflineService";
    ForceOfflineReceiver forceOfflineReceiver;
    @Override
    public void onCreate() {
        Log.i(TAG, "ExampleService-onCreate");
        super.onCreate();

        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.sso");
        forceOfflineReceiver=new ForceOfflineReceiver();
        registerReceiver(forceOfflineReceiver, intentFilter);

        Intent intent =new Intent("com.sso");
        getApplicationContext().sendBroadcast(intent);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.i(TAG, "ExampleService-onStart");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //执行文件的下载或者播放等操作
        Log.i(TAG, "ExampleService-onStartCommand");
        /*
         * 这里返回状态有三个值，分别是:
         * 1、START_STICKY：当服务进程在运行时被杀死，系统将会把它置为started状态，但是不保存其传递的Intent对象，之后，系统会尝试重新创建服务;
         * 2、START_NOT_STICKY：当服务进程在运行时被杀死，并且没有新的Intent对象传递过来的话，系统将会把它置为started状态，
         *   但是系统不会重新创建服务，直到startService(Intent intent)方法再次被调用;
         * 3、START_REDELIVER_INTENT：当服务进程在运行时被杀死，它将会在隔一段时间后自动创建，并且最后一个传递的Intent对象将会再次传递过来。
         */
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "ExampleService-onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "ExampleService-onDestroy");
        super.onDestroy();
        unregisterReceiver(forceOfflineReceiver);
    }
}
