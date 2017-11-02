package com.bwie.myapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.myapp.R;
import com.bwie.myapp.mvp.presentet.RegisterPresenter;
import com.bwie.myapp.mvp.presentet.RegisterPresenterImpl;
import com.bwie.myapp.mvp.view.RegisterView;

public class RegisterActivity extends BaseActivity implements RegisterView, View.OnClickListener {

    private Button bt_register;
    private EditText register_pwd;
    private EditText register_phone;
    private TextView exisingUser;
    private ImageButton register_back;
    private RegisterPresenter registerPresenter;
    private Button register_tourist_login;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //初始化组件
        register_back = findViewById(R.id.register_back);
        exisingUser = findViewById(R.id.exisingUser);
        register_phone = findViewById(R.id.register_phone);
        register_pwd = findViewById(R.id.register_pwd);
        bt_register = findViewById(R.id.bt_register);
        register_tourist_login = findViewById(R.id.register_tourist_login);

        registerPresenter = new RegisterPresenterImpl(this);
        bt_register.setOnClickListener(this);
        exisingUser.setOnClickListener(this);
        register_tourist_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.exisingUser:
                intent = new Intent(RegisterActivity.this,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.register_tourist_login:
                intent = new Intent(RegisterActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.bt_register:
                registerPresenter.registerPresenter(this,register_phone.getText().toString(),register_pwd.getText().toString());
                break;
        }
    }
    @Override
    public void setPhone() {
        register_phone.setError("Phone can not Empty");
    }

    @Override
    public void setPwd() {
        register_pwd.setError("PassWord can not Empty");
    }

    @Override
    public void OnSuccess() {
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnUnSuccessful() {
        Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
    }

}
