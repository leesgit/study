package com.example.lkoon.movieboja.presenter;

import android.app.Activity;
import android.content.Context;

import com.example.lkoon.movieboja.listener.OnItemClickListener;

/**
 * Created by lkoon on 2017-08-30.
 */

public interface MovieBojaContract {
    interface View {
        void showToast(String msg);
    }

    interface Presenter {
        void    sendIdAndPasswordToServer(String id, String pw, Activity context);
        void sendJoinInfo(String id, String pw, String name, String phone, String Email, Context context);

        void joincheck(Context context, String id, String pw, String name, String phone, String Email);
    }
}
