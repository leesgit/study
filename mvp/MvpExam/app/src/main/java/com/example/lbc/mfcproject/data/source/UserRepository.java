package com.example.lbc.mfcproject.data.source;

import android.content.Context;

import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.data.source.remote.UserRemoteDataSource;

import java.util.List;

/**
 * Created by lbc on 2018-01-06.
 */

public class UserRepository implements UserDataSource {

    private UserRemoteDataSource userRemoteDataSource = new UserRemoteDataSource();

    private static UserRepository userRepository;

    public static UserRepository getInstance(){
        if (userRepository==null) {
            userRepository=new UserRepository();
        }
        return userRepository;
    }

    @Override
    public void doSearch(Context context, Id id, List<Id> ids, final LoadDataCallBack loadDataCallBack) {
        userRemoteDataSource.doSearch(context, id, ids,loadDataCallBack);

//        userRemoteDataSource.doSearch(context, id, ids, new LoadDataCallBack() {
//            @Override
//            public void onLoadData(List<Id> ids) {
//                loadDataCallBack.onLoadData(ids);
//            }
//
//            @Override
//            public void onFailData(String errorMsg) {
//                loadDataCallBack.onFailData(errorMsg);
//            }
//        });
    }
}
