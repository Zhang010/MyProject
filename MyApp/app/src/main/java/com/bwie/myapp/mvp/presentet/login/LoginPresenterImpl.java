package com.bwie.myapp.mvp.presentet.login;

import android.content.Context;

import com.bwie.myapp.mvp.model.login.LoginModel;
import com.bwie.myapp.mvp.model.login.LoginModelImpl;
import com.bwie.myapp.mvp.view.login.LoginListener;
import com.bwie.myapp.mvp.view.login.LoginView;

/**
 * Created by 13435 on 2017/11/6.
 */

public class LoginPresenterImpl implements LoginPresenter,LoginListener{

    LoginView loginView;
    LoginModel loginModel;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;

        loginModel = new LoginModelImpl();
    }

    @Override
    public void loginPresenter(Context ctx, String phone, String pwd) {
        loginModel.login(ctx,phone,pwd,this);
    }

    @Override
    public void OnPhone() {
        if(loginView != null){
            loginView.setPhone();
        }
    }

    @Override
    public void OnPwd() {
        if(loginView != null){
            loginView.setPwd();
        }
    }

    @Override
    public void Success() {
        if(loginView != null){
            loginView.OnSuccess();
        }
    }

    @Override
    public void UnSuccessful() {
        if(loginView != null){
            loginView.OnUnSuccessful();
        }
    }
}
