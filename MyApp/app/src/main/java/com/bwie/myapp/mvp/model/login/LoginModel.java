package com.bwie.myapp.mvp.model.login;

import android.content.Context;

import com.bwie.myapp.mvp.view.login.LoginListener;

/**
 * Created by 13435 on 2017/11/6.
 */

public interface LoginModel {
    void login(Context ctx, String phone, String pwd, LoginListener listener);
}
