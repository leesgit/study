package com.example.lbc.mfcproject.view.presenter;

import android.content.Context;

import com.example.lbc.mfcproject.adapter.PointAdapter;
import com.example.lbc.mfcproject.adapter.contract.RecyclerAdapterContract;
import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.data.source.PointDataSource;

import java.util.List;

/**
 * Created by lbc on 2018-01-08.
 */

public class RankPresenter implements RankContract.Presenter {
    PointDataSource pointDataSource;
    RankContract.View view;
    RecyclerAdapterContract.View adapterView;
    RecyclerAdapterContract.Model adapterModel;

    public RankPresenter(PointDataSource pointDataSource, RankContract.View view) {
        this.pointDataSource = pointDataSource;
        this.view = view;
    }

    @Override
    public void findRank(Context context, List<Id> ids) {
        adapterModel.clearItem();
        pointDataSource.findRank(context, ids, new PointDataSource.LoadDataCallBack() {
            @Override
            public void onLoadData(List<Id> ids) {
                adapterModel.addItems(ids);
                adapterView.notifyAdapter();
            }

            @Override
            public void onFailData(String errorMsg) {
                view.showToast(errorMsg);
            }
        });
    }

    @Override
    public void setImageAdapterModel(RecyclerAdapterContract.Model adapterModel) {
        this.adapterModel =adapterModel;
    }

    @Override
    public void setImageAdapterView(RecyclerAdapterContract.View adapterView) {
        this.adapterView = adapterView;
    }
}
