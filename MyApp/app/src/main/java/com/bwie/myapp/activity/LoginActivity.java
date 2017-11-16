package com.bwie.myapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.myapp.R;
import com.bwie.myapp.base.BaseActivity;
import com.bwie.myapp.mvp.presentet.login.LoginPresenter;
import com.bwie.myapp.mvp.presentet.login.LoginPresenterImpl;
import com.bwie.myapp.mvp.view.login.LoginView;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

    private ImageButton login_back;
    private TextView register_new;
    private EditText login_phone;
    private EditText login_pwd;
    private Button bt_login;
    private Button forget_pwd;
    private Button login_tourist_login;
    private LoginPresenter loginPresenter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //初始化组件
        login_back = findViewById(R.id.login_back);
        register_new = findViewById(R.id.register_new);
        login_phone = findViewById(R.id.login_phone);
        login_pwd = findViewById(R.id.login_pwd);
        bt_login = findViewById(R.id.bt_login);
        forget_pwd = findViewById(R.id.forget_pwd);
        login_tourist_login = findViewById(R.id.login_tourist_login);

        login_back.setOnClickListener(this);
        register_new.setOnClickListener(this);
        bt_login.setOnClickListener(this);
        forget_pwd.setOnClickListener(this);
        login_tourist_login.setOnClickListener(this);

        loginPresenter = new LoginPresenterImpl(this);

    }

    @Override
    public void setPhone() {
        login_phone.setError("Phone is Error");
    }

    @Override
    public void setPwd() {
        login_pwd.setError("PaassWord is Error");
    }

    @Override
    public void OnSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void OnUnSuccessful() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login_back:
                this.finish();
                break;
            case R.id.register_new:
                intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_login:
                loginPresenter.loginPresenter(this,login_phone.getText().toString(),login_pwd.getText().toString());
                break;
            case R.id.forget_pwd:
                break;
            case R.id.login_tourist_login:
                intent = new Intent(LoginActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
