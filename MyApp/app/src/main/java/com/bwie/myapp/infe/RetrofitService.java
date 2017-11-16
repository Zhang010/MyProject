package com.bwie.myapp.infe;

import com.bwie.myapp.bean.LoginBean;
import com.bwie.myapp.bean.RegisterBean;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 13435 on 2017/11/2.
 */

public interface RetrofitService {

      /*1.用户注册接口（接口描述，实现用户注册功能）

        接口地址	http://192.168.1.100/quarter/user/addUser
        请求方式	Post
        参数列表	参数名称	别名	类型	备注
        userName	用户名	varchar
        userPassword	密码	varchar
        userPhone	电话号码	varchar	后台进行唯一验证
        userSex	性别	char
        错误示例	{"code","500!message:"+注册电话号+"已存在!!!!!!"}
        成功示例	{"code":200}*/
      @POST("addUser")
      @FormUrlEncoded
      Flowable<RegisterBean> getRegister(@Field("userName") String userName, @Field("userPassword") String userPassword, @Field("userPhone") String userPhone, @Field("userSex") String userSex);

      /*接口地址	http://192.168.1.100/quarter/user/addLogin
      请求方式	Post
      参数列表	参数名称	别名	类型	备注
      userPassword	密码	varchar
      userPhone	电话号码	varchar
      错误示例	{"code":500，"message", "用户名或密码有误登陆失败！"}
      成功示例	{"code":"200","user":{"userHead":"打开疯狂的","userId":6,"userName":"小明","userPassword":"111","userPhone":"13011196165","userSex":"男"}}
      */
      @POST("addLogin")
      @FormUrlEncoded
      Flowable<LoginBean> getLogin(@Field("userPassword") String userPassword, @Field("userPhone")String userPhone);
}
