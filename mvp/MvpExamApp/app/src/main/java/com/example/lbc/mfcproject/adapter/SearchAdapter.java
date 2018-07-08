package com.example.lbc.mfcproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lbc.mfcproject.R;
import com.example.lbc.mfcproject.adapter.contract.RecyclerAdapterContract;
import com.example.lbc.mfcproject.adapter.holder.SearchViewHolder;
import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbc on 2017-12-10.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder>  implements RecyclerAdapterContract.Model, RecyclerAdapterContract.View {

    List<Id>  ids = new ArrayList<>();
    private OnItemClickListener onItemClickListener;


    public SearchAdapter(List<Id> ids) {
        this.ids = ids;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item, parent, false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(view,onItemClickListener);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        holder.setData(ids.get(position),position);
    }

    @Override
    public int getItemCount() {
        return ids.size();
    }

    @Override
    public void setOnclickListener(OnItemClickListener onclickListener) {
        this.onItemClickListener = onclickListener;

    }

    @Override
    public void notifyAdapter() {
        notifyDataSetChanged();
    }


    @Override
    public void addItems(List<Id> ids) {
        this.ids = ids;

    }

    @Override
    public void clearItem() {
        if (ids!=null) {
            ids.clear();
        }
    }

    @Override
    public Id getId(int position) {
        return ids.get(position);
    }
}
