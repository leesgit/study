package com.example.lbc.mfcproject.view.presenter;

import android.content.Context;

import com.example.lbc.mfcproject.data.Id;

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
