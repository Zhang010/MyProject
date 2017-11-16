package com.bwie.myapp.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bwie.myapp.R;
import com.bwie.myapp.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends BaseActivity {

    private SimpleDraweeView icon1;
    private TextView title;
    private ImageView icon2;
    private FrameLayout frame;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化组件
        icon1 = findViewById(R.id.icon1);
        title = findViewById(R.id.title);
        icon2 = findViewById(R.id.icon2);
        frame = findViewById(R.id.frame);
        rg = findViewById(R.id.rg);
    }
}
