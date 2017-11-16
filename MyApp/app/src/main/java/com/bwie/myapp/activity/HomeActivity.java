package com.bwie.myapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.bwie.myapp.R;
import com.bwie.myapp.base.BaseActivity;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private ImageButton home_back;
    private Button wx_login;
    private Button qq_login;
    private Button other_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //初始化组件
        home_back = findViewById(R.id.home_back);
        wx_login = findViewById(R.id.wx_login);
        qq_login = findViewById(R.id.qq_login);
        other_login = findViewById(R.id.other_login);

        home_back.setOnClickListener(this);
        wx_login.setOnClickListener(this);
        qq_login.setOnClickListener(this);
        other_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.home_back:
                this.finish();
                break;
            case R.id.wx_login:
                break;
            case R.id.qq_login:
                break;
            case R.id.other_login:
                Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
