package com.example.performance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.TraceCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.example.performance.memory.MemoryShakeActivity;
import com.example.performance.util.LaunchTimer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv);
        tv.getViewTreeObserver()
                .addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {// 对tv视图树进行可视状态的监听，并且计算结束观测的时间
                    @Override
                    public boolean onPreDraw() {
                        tv.getViewTreeObserver().removeOnPreDrawListener(this); //对tv进行监听后还需要进行注销
                        Log.e("启动时间计算", "在tv刚被显示出来时进行监听");
                        LaunchTimer.endRecord();
                        return true;
                    }
                });
        //Debug.stopMethodTracing();  // 结束traceview
        TraceCompat.endSection();
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.e("启动时间计算", "在onWindowFocusChanged()中进行监听");
        LaunchTimer.endRecord();
    }

    public void JumpToMemoryThrashing(View view) {
        Intent intent = new Intent(MainActivity.this, MemoryShakeActivity.class);
        startActivity(intent);
    }
}