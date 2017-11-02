package com.bwie.myapp.mvp.model;

import android.content.Context;
import android.widget.Button;

import com.bwie.myapp.mvp.view.RegisterListener;

/**
 * Created by 13435 on 2017/10/31.
 */

public interface RegisterModel {

    void register(Context ctx, String phone, String pwd, RegisterListener listener);
}
