package com.bwie.myapp.mvp.presentet.register;

import android.content.Context;

import com.bwie.myapp.mvp.model.register.RegisterModel;
import com.bwie.myapp.mvp.model.register.RegisterModelImpl;
import com.bwie.myapp.mvp.view.register.RegisterListener;
import com.bwie.myapp.mvp.view.register.RegisterView;

/**
 * Created by 13435 on 2017/10/31.
 */

public class RegisterPresenterImpl implements RegisterPresenter,RegisterListener{

    RegisterView registerView;
    RegisterModel registerModel;

    public RegisterPresenterImpl(RegisterView registerView) {
        this.registerView = registerView;

        registerModel = new RegisterModelImpl();
    }

    @Override
    public void registerPresenter(Context ctx, String phone, String pwd) {
        registerModel.register(ctx,phone,pwd,this);
    }

    @Override
    public void OnPhone() {
        if(registerView !=null){
            registerView.setPhone();
        }
    }

    @Override
    public void OnPwd() {
        if(registerView !=null){
            registerView.setPwd();
        }
    }

    @Override
    public void Success() {
        if(registerView !=null){
            registerView.OnSuccess();
        }
    }

    @Override
    public void UnSuccessful() {
        if(registerView !=null){
            registerView.OnUnSuccessful();
        }
    }
}
