package com.example.lkoon.movieboja.data.source;

import android.content.Context;

import com.example.lkoon.movieboja.data.source.remote.UserRemoteDataSource;
import com.example.lkoon.movieboja.model.User;

/**
 * Created by lkoon on 2017-08-12.
 */

public class UserRepository implements UserDataSource {

    private UserRemoteDataSource userRemoteDataSource = new UserRemoteDataSource();

    @Override
    public void doLogin(Context context, User user, final LoadDataCallBack callBack) {
        userRemoteDataSource.doLogin(context, user, new LoadDataCallBack() {
            @Override
            public void onLoadData(String servermsg) {
                callBack.onLoadData(servermsg);
            }

            @Override
            public void onFailData(String errorMsg) {
                callBack.onFailData(errorMsg);
            }
        });
    }

    @Override
    public void doJoin(Context context, User user, final LoadDataCallBack callBack) {
        userRemoteDataSource.doJoin(context, user, new LoadDataCallBack() {
            @Override
            public void onLoadData(String servermsg) {
                callBack.onLoadData(servermsg);
            }

            @Override
            public void onFailData(String errorMsg) {
                callBack.onFailData(errorMsg);
            }
        });
    }
}
