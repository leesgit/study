package com.example.lbc.mfcproject.main;

import android.content.Context;

import com.example.lbc.mfcproject.adapter.PointAdapter;
import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.data.source.PointDataSource;

import java.util.List;

/**
 * Created by lbc on 2018-01-08.
 */

public class RankPresenter implements RankContract.Presenter {
    PointDataSource pointDataSource;
    RankContract.View view;
    PointAdapter pointAdapter;

    public RankPresenter(PointDataSource pointDataSource, RankContract.View view, PointAdapter pointAdapter) {
        this.pointDataSource = pointDataSource;
        this.view = view;
        this.pointAdapter = pointAdapter;
    }

    @Override
    public void findRank(Context context, List<Id> ids) {
        pointAdapter.clearItem();
        pointDataSource.findRank(context, ids, new PointDataSource.LoadDataCallBack() {
            @Override
            public void onLoadData(List<Id> ids) {
                pointAdapter.addItems(ids);
                pointAdapter.notifyAdapter();
            }

            @Override
            public void onFailData(String errorMsg) {
                view.showToast(errorMsg);
            }
        });
    }
}
