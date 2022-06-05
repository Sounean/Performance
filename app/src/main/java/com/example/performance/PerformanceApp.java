package com.example.performance;

import android.app.Application;
import android.content.Context;
import android.os.Debug;

import androidx.core.os.TraceCompat;

import com.example.performance.util.LaunchTimer;

/**
 * @Author : Sounean
 * @Time : On 2022-06-05 15:30
 * @Description : PerformanceApp
 * @Warn :
 */
public class PerformanceApp extends Application {

    @Override
    protected void attachBaseContext(Context base) {    //这个生命周期一般是刚开始的时间
        super.attachBaseContext(base);
        //Debug.startMethodTracing("App");   // 开始使用traceview
        TraceCompat.beginSection("ApponCreate");
        LaunchTimer.startRecord();
    }
}
