package com.example.lbc.mfcproject.data.source;

import android.content.Context;

import com.example.lbc.mfcproject.data.Id;

import java.util.List;

/**
 * Created by lbc on 2018-01-08.
 */

public interface PointDataSource {

    interface LoadDataCallBack {
        void onLoadData(List<Id> ids);
        void onFailData(String errorMsg);
    }

    void findRank(Context context, List<Id>ids, LoadDataCallBack loadDataCallBack);
}
