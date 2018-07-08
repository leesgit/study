package com.example.lbc.mfcproject.data.source.remote;

import android.content.Context;
import android.util.Log;

import com.example.lbc.mfcproject.RetrofitManager;
import com.example.lbc.mfcproject.adapter.SearchAdapter;
import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.data.source.UserDataSource;

import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lbc on 2018-01-06.
 */

public class UserRemoteDataSource implements UserDataSource {


    @Override
    public void doSearch(Context context, final Id id, final List<Id> ids,final LoadDataCallBack loadDataCallBack) {

        RetrofitManager.getInstance().getUrl().search(id).enqueue(new Callback<List<Id>>() {
            @Override
            public void onResponse(Call<List<Id>> call, Response<List<Id>> response) {
                if(loadDataCallBack != null)
                    loadDataCallBack.onLoadData(response.body());
            }

            @Override
            public void onFailure(Call<List<Id>> call, Throwable t) {
                loadDataCallBack.onFailData("검색 오류");
                Log.e("검색오류","??",t);
            }
        });
    }
}
