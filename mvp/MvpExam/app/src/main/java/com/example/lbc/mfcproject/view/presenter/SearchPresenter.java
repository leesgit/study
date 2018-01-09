package com.example.lbc.mfcproject.view.presenter;

import android.content.Context;

import com.example.lbc.mfcproject.adapter.SearchAdapter;
import com.example.lbc.mfcproject.adapter.contract.RecyclerAdapterContract;
import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.data.source.UserDataSource;
import com.example.lbc.mfcproject.listener.OnItemClickListener;

import java.util.List;

/**
 * Created by lbc on 2018-01-06.
 */

public class SearchPresenter implements SearchContract.Presenter, OnItemClickListener {
    UserDataSource dataSource;
    SearchContract.View view;
    RecyclerAdapterContract.Model adapterModel;
    RecyclerAdapterContract.View adapterView;


    public SearchPresenter( UserDataSource dataSource, SearchContract.View view) {
        this.dataSource = dataSource;
        this.view = view;
    }

    @Override
    public void doSearch(Context context, Id id, List<Id> ids) {
        adapterModel.clearItem();

        dataSource.doSearch(context, id, ids, new UserDataSource.LoadDataCallBack() {
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
        this.adapterModel = adapterModel;

    }

    @Override
    public void setImageAdapterView(RecyclerAdapterContract.View adapterView) {
        this.adapterView = adapterView;

    }

    @Override
    public void onItemClick(int position) {
    }
}
