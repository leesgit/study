package com.example.lbc.mfcproject.data.source.remote;

import android.content.Context;
import android.util.Log;

import com.example.lbc.mfcproject.RetrofitManager;
import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.data.source.PointDataSource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lbc on 2018-01-08.
 */

public class PointRemoteDataSource implements PointDataSource {
    @Override
    public void findRank(Context context, final List<Id> ids, final LoadDataCallBack loadDataCallBack) {
        RetrofitManager.getInstance().getUrl().point().enqueue(new Callback<List<Id>>() {
            @Override
            public void onResponse(Call<List<Id>> call, Response<List<Id>> response) {
                loadDataCallBack.onLoadData(response.body());
            }

            @Override
            public void onFailure(Call<List<Id>> call, Throwable t) {
                loadDataCallBack.onFailData("검색 오류");
            }
        });
    }
}
