package com.example.lbc.mfcproject.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lbc.mfcproject.R;
import com.example.lbc.mfcproject.adapter.SearchAdapter;
import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.data.source.UserRepository;
import com.example.lbc.mfcproject.view.presenter.SearchContract;
import com.example.lbc.mfcproject.view.presenter.SearchPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbc on 2017-12-04.
 */

public class FragmentSearch extends Fragment implements SearchContract.View {

    RecyclerView searchRecycler;
    LinearLayoutManager linearLayoutManager;
    List<Id> ids = new ArrayList<>();;
    SearchAdapter searchAdapter;
    Button btnSearch;
    EditText etSearch;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search,container,false);
        btnSearch = view.findViewById(R.id.btnSearch);
        etSearch = view.findViewById(R.id.etSearch);
        final SearchContract.Presenter presenter;

        ids = new ArrayList<>();
        searchRecycler =(RecyclerView)view.findViewById(R.id.searchRecycler);
        linearLayoutManager = new LinearLayoutManager(container.getContext(), LinearLayoutManager.VERTICAL, false);
        searchRecycler.setLayoutManager(linearLayoutManager);
        searchAdapter = new SearchAdapter(ids);
        searchRecycler.setAdapter(searchAdapter= new SearchAdapter(ids));

        presenter = new SearchPresenter(searchAdapter,UserRepository.getInstance(),this);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Id id = new Id(etSearch.getText().toString());
                presenter.doSearch(getActivity(),id,ids);

            }
        });
        return view;
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}
