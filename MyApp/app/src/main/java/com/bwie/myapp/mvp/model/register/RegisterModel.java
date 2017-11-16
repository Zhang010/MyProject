package com.bwie.myapp.mvp.model.register;

import android.content.Context;

import com.bwie.myapp.mvp.view.register.RegisterListener;

/**
 * Created by 13435 on 2017/10/31.
 */

public interface RegisterModel {

    void register(Context ctx, String phone, String pwd, RegisterListener listener);
}
