package com.bwie.myapp.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 13435 on 2017/11/2.
 */

public class RegisterBean {


    /**
     * code : 500
     * ”message” : 注册电话号已存在!!!!!!
     */

    private int code;
    @SerializedName("”message”")
    private String _$Message260; // FIXME check this code

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String get_$Message260() {
        return _$Message260;
    }

    public void set_$Message260(String _$Message260) {
        this._$Message260 = _$Message260;
    }
}
