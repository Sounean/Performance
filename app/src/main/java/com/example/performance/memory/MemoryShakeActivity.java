package com.example.performance.memory;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.performance.R;

/**
 * 模拟内存抖动的界面
 */
public class MemoryShakeActivity extends AppCompatActivity implements View.OnClickListener {

    @SuppressLint("HandlerLeak")
    private static Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // 创造内存抖动
//            for (int index = 0; index <= 100; index++) {
//                String arg[] = new String[1000000000];// 耗内存的操作
//            }
            String[] str = new String[5];
            str[0] = "a";
            str[1] = "b";
            str[2] = "c";
            str[3] = "d";
            str[4] = "e";
            for (int index = 0; index <= 100; index++) {
                addStr(str);// 耗内存的操作
            }
            mHandler.sendEmptyMessageDelayed(0, 10);// 每隔20毫秒执行一次
        }
    };

    public static String addStr(String[] values) {

        String result = null;

        for(int i = 0; i < values.length; i++) {

            result += values[i];

        }

        return result;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        findViewById(R.id.bt_memory).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        mHandler.sendEmptyMessage(0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }
}
