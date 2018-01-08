package com.example.lbc.mfcproject.presenter;

import android.content.Context;

import com.example.lbc.mfcproject.data.Id;

import java.util.List;

/**
 * Created by lbc on 2018-01-08.
 */

public interface RankContract {

    interface View {
        void showToast(String msg);
    }

    interface Presenter {
        void findRank(Context context, List<Id> ids );
    }
}
