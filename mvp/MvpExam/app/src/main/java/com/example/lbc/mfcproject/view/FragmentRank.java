package com.example.lbc.mfcproject.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lbc.mfcproject.R;
import com.example.lbc.mfcproject.adapter.PointAdapter;
import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.data.source.PointRepository;
import com.example.lbc.mfcproject.view.presenter.RankContract;
import com.example.lbc.mfcproject.view.presenter.RankPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbc on 2017-12-04.
 */

public class FragmentRank extends Fragment implements RankContract.View {
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView pointRecycler;
    LinearLayoutManager linearLayoutManager;
    List<Id> ids = new ArrayList<>();;
    PointAdapter pointAdapter;
    RankContract.Presenter presenter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_rank,container,false);

        pointRecycler =(RecyclerView)view.findViewById(R.id.pointRecycler);
        linearLayoutManager = new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false);
        pointRecycler.setLayoutManager(linearLayoutManager);
        pointAdapter = new PointAdapter(ids);
        pointRecycler.setAdapter(pointAdapter= new PointAdapter(ids));
        ids = new ArrayList<>();
        presenter = new RankPresenter(PointRepository.getInstance(),this,pointAdapter);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                load();
                swipeRefreshLayout.setRefreshing(false);
                //PointViewHolder.rank=1;
            }
        });



        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        load();
    }

    private synchronized void load() {
        presenter.findRank(getActivity(),ids);
    }

    @Override
    public void showToast(String msg) {

    }
}
