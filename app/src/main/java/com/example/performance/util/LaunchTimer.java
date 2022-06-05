package com.example.performance.util;

import android.util.Log;

/**
 * @Author : Sounean
 * @Time : On 2022-06-05 15:27
 * @Description : LaunchTimer
 * @Warn :
 */
public class LaunchTimer {

    private static long sTime;

    public static void startRecord() {
        sTime = System.currentTimeMillis();
    }   // 保存开始的时间

    public static void endRecord() {
        endRecord("");
    }   // 保存结束的时间

    public static void endRecord(String msg) {
        long cost = System.currentTimeMillis() - sTime;
        //log.i(msg + "cost " + cost);
        Log.e("启动时间计算", "cost " + cost);
    }

}
