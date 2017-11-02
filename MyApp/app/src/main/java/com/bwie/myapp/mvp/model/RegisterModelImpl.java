package com.bwie.myapp.mvp.model;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.bwie.myapp.bean.RegisterBean;
import com.bwie.myapp.infe.RetrofitService;
import com.bwie.myapp.mvp.view.RegisterListener;
import com.bwie.myapp.utils.API;
import com.bwie.myapp.utils.RetrofitUtil;
import com.bwie.myapp.utils.TelNumMatch;
import com.bwie.myapp.utils.VetifyOnPwd;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 13435 on 2017/10/31.
 */

public class RegisterModelImpl implements RegisterModel {
    @Override
    public void register(final Context ctx, final String phone, final String pwd, final RegisterListener listener) {


        //校验手机号
        if(TextUtils.isEmpty(phone)){
            listener.OnPhone();
            return;
        }
        if(!TelNumMatch.isValidPhoneNumber(phone)){
            Toast.makeText(ctx, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        //校验密码
        if(TextUtils.isEmpty(pwd)){
            listener.OnPwd();
            return;
        }
        if(VetifyOnPwd.isSpecific_Symbol(ctx,pwd) == false){
            return;
        }
        if(pwd.length()>8){
            Toast.makeText(ctx, "密码格式不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        Call<RegisterBean> register = RetrofitUtil.getInstance()
                .getApiService(API.IP, RetrofitService.class)
                .getRegister("zhang", pwd, phone, "男");
        register.enqueue(new Callback<RegisterBean>() {
            @Override
            public void onResponse(Call<RegisterBean> call, Response<RegisterBean> response) {
                RegisterBean body = response.body();
                if(body.getCode() == 200){
                    listener.Success();
                    Toast.makeText(ctx, "注册成功", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<RegisterBean> call, Throwable t) {
                Toast.makeText(ctx, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
