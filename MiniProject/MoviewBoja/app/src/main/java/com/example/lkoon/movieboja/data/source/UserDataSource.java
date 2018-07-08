package com.example.lkoon.movieboja.data.source;

import android.content.Context;

import com.example.lkoon.movieboja.model.User;

/**
 * Created by lkoon on 2017-08-12.
 */

public interface UserDataSource {
    interface LoadDataCallBack {
        void onLoadData(String servermsg);
        void onFailData(String errorMsg);
    }

    void doLogin(Context context, User user, LoadDataCallBack callBack);
    void doJoin(Context context, User user, LoadDataCallBack callBack);
}
