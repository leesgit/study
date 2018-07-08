package com.example.lkoon.movieboja.data.source.remote;

import android.content.Context;
import android.util.Log;

import com.example.lkoon.movieboja.Interface.UserService;
import com.example.lkoon.movieboja.data.source.UserDataSource;
import com.example.lkoon.movieboja.model.SimpleResult;
import com.example.lkoon.movieboja.model.User;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lkoon on 2017-08-12.
 */

public class UserRemoteDataSource implements UserDataSource {
    Retrofit retrofit;
    OkHttpClient okHttpClient;
    UserService userService;
    @Override
    public void doLogin(Context context, User user, final LoadDataCallBack callBack) {
        okHttpClient = new OkHttpClient();
        retrofit = new Retrofit.Builder().client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).baseUrl
                ("http://192.168.43.38:8080/user/login/").build();
        userService = retrofit.create(UserService.class);

        userService.login(user).enqueue(new Callback<SimpleResult>() {
            @Override
            public void onResponse(Call<SimpleResult> call, retrofit2.Response<SimpleResult> response) {
                SimpleResult result = response.body();
                String message = result.getMessage();
                Log.d("UserRepository", message);
                if(result.getResult()==200){        // 로그인 성공
                    callBack.onLoadData(message);

                }
                else{
                    callBack.onFailData("로그인에 실패했습니다.");
                }

            }

            @Override
            public void onFailure(Call<SimpleResult> call, Throwable t) {
                callBack.onFailData("네트워크 상태를 확인해 주세요.");
            }
        });
    }

    @Override
    public void doJoin(Context context, User user,final LoadDataCallBack callBack) {

        okHttpClient = new OkHttpClient();
        retrofit = new Retrofit.Builder().client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).baseUrl
                ("http://192.168.43.38:8080/user/join/").build();
        userService = retrofit.create(UserService.class);

        userService.join(user).enqueue(new Callback<SimpleResult>() {
            @Override
            public void onResponse(Call<SimpleResult> call, retrofit2.Response<SimpleResult> response) {
                SimpleResult result = response.body();
                String message = result.getMessage();

                if(result.getResult()==200){
//                    Toast.makeText(getApplicationContext(),message, Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
//                    startActivity(intent);
                    callBack.onLoadData(message);

                }
                else{
//                    Toast.makeText(getApplicationContext(),"회원가입 실패", Toast.LENGTH_LONG).show();
                    callBack.onFailData("회원가입 실패");
                }

            }

            @Override
            public void onFailure(Call<SimpleResult> call, Throwable t) {
                callBack.onFailData("네트워크 상태를 확인해 주세요.");
            }
        });

    }
}
