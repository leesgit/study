package com.example.lbc.mfcproject.data.source;

import android.content.Context;

import com.example.lbc.mfcproject.adapter.SearchAdapter;
import com.example.lbc.mfcproject.data.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbc on 2018-01-06.
 */

public interface UserDataSource {

    interface LoadDataCallBack {
        void onLoadData(List<Id> ids);
        void onFailData(String errorMsg);
    }

    void doSearch(Context context, Id id, List<Id> ids , LoadDataCallBack loadDataCallBack);
}
