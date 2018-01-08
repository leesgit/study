package com.example.lbc.mfcproject.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.lbc.mfcproject.adapter.SearchAdapter;
import com.example.lbc.mfcproject.adapter.contract.SearchAdapterContract;
import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.data.source.UserDataSource;
import com.example.lbc.mfcproject.data.source.UserRepository;
import com.example.lbc.mfcproject.listener.OnItemClickListener;

import java.util.List;

/**
 * Created by lbc on 2018-01-06.
 */

public class SearchPresenter implements SearchContract.Presenter, OnItemClickListener {
    UserDataSource dataSource;
    SearchContract.View view;
    SearchAdapter searchAdapter;

    public SearchPresenter(SearchAdapter searchAdapter, UserDataSource dataSource, SearchContract.View view) {
        this.searchAdapter =searchAdapter;
        this.dataSource = dataSource;
        this.view = view;
    }

    @Override
    public void doSearch(Context context, Id id, List<Id> ids) {
        searchAdapter.clearItem();

        dataSource.doSearch(context, id, ids, new UserDataSource.LoadDataCallBack() {
            @Override
            public void onLoadData(List<Id> ids) {
                searchAdapter.addItems(ids);
                searchAdapter.notifyAdapter();
            }

            @Override
            public void onFailData(String errorMsg) {
                view.showToast(errorMsg);
            }
        });

    }
    @Override
    public void onItemClick(int position) {
        Id id = searchAdapter.getId(position);
    }
}
