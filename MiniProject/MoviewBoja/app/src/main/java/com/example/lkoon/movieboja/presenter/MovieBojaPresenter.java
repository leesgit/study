package com.example.lkoon.movieboja.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.lkoon.movieboja.data.source.UserDataSource;
import com.example.lkoon.movieboja.listener.OnItemClickListener;
import com.example.lkoon.movieboja.model.User;
import com.example.lkoon.movieboja.view.MainActivity;
import com.example.lkoon.movieboja.view.SignInActivity;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by lkoon on 2017-08-30.
 */

public class MovieBojaPresenter implements MovieBojaContract.Presenter,OnItemClickListener {

    User user;
    MovieBojaContract.View view;
    UserDataSource dataSource;

    public MovieBojaPresenter(MovieBojaContract.View view, UserDataSource dataSource) {
        this.view =view;
        this.dataSource = dataSource;
    }



    @Override
    public void sendIdAndPasswordToServer(String id, String pw, final Activity context) {
        user = new User(id, pw);
        dataSource.doLogin(context, user, new UserDataSource.LoadDataCallBack() {
            @Override
            public void onLoadData(String message) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("pref", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("id", user.getId());
                editor.commit();
                view.showToast(message);

                Intent intent = new Intent(context,MainActivity.class);
                context.startActivity(intent);
            }

            @Override
            public void onFailData(String errorMsg) {
                view.showToast(errorMsg);
            }
        });
    }


    @Override
    public void sendJoinInfo(String id, String pw, String name, String phone, String email, final Context context) {
        user = new User(id,pw,name,phone,email);

        dataSource.doJoin(context, user, new UserDataSource.LoadDataCallBack() {
            @Override
            public void onLoadData(String servermsg) {

                view.showToast(servermsg);
                Intent intent = new Intent(context,SignInActivity.class);
                context.startActivity(intent);
            }

            @Override
            public void onFailData(String errorMsg) {
                view.showToast(errorMsg);
            }
        });
    }

    @Override
    public void joincheck(Context context, String id, String pw, String name, String phone, String Email) {
        String errorMsg = "";
        if(id.equals("")){
            errorMsg = "아이디 오류";
        }
        else if (pw.equals("")){
            errorMsg = "비번 오류";
        }
        else if (name.equals("")){
            errorMsg = "이름 오류";
        }
        else if (phone.equals("")){
            errorMsg = "번호 오류";
        }
        else if (Email.equals("")){
            errorMsg = "이메일 오류";
        }

        if(!errorMsg.equals("")){
            view.showToast(errorMsg);
        }else {
            sendJoinInfo(id, pw, name, phone,  Email, context);
        }
    }

    @Override
    public void onItemClick(int position) {

    }
}
