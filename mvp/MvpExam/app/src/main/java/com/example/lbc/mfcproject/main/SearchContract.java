package com.example.lbc.mfcproject.main;

import android.content.Context;

import com.example.lbc.mfcproject.adapter.SearchAdapter;
import com.example.lbc.mfcproject.adapter.contract.SearchAdapterContract;
import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.data.source.UserDataSource;

import java.util.List;

/**
 * Created by lbc on 2018-01-06.
 */

public interface SearchContract {

    interface View {
        void showToast(String msg);
    }

    interface Presenter {
        void doSearch(Context context, Id id, List<Id> ids );
    }
}
