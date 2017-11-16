package com.bwie.myapp.mvp.model.login;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.bwie.myapp.bean.LoginBean;
import com.bwie.myapp.infe.RetrofitService;
import com.bwie.myapp.mvp.view.login.LoginListener;
import com.bwie.myapp.utils.API;
import com.bwie.myapp.utils.RetrofitUtil;

import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 13435 on 2017/11/6.
 */

public class LoginModelImpl implements LoginModel {
    @Override
    public void login(final Context ctx, String phone, String pwd, final LoginListener listener) {
        if(TextUtils.isEmpty(phone)){
            listener.OnPhone();
            return;
        }
        if(TextUtils.isEmpty(pwd)){
            listener.OnPwd();
            return;
        }
        final Flowable<LoginBean> login = RetrofitUtil.getInstance().getApiService(API.IP, RetrofitService.class)
                .getLogin(pwd, phone);
        login.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new FlowableSubscriber<LoginBean>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Integer.MAX_VALUE);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        if(loginBean.getCode() == 200){
                            listener.Success();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        listener.UnSuccessful();
                        Log.e("Tag",t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(ctx, "...", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
