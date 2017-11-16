package com.bwie.myapp.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwie.myapp.R;
import com.bwie.myapp.base.BaseActivity;

public class WelcomeActivity extends BaseActivity {

    private int i=3;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(i>0){
                i--;
                handler.postDelayed(runnable,1000);
            }else{
                Intent intent = new Intent(WelcomeActivity.this,HomeActivity.class);
                startActivity(intent);
                handler.removeCallbacksAndMessages(runnable);
                WelcomeActivity.this.finish();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        handler.postDelayed(runnable,1000);
    }
}
