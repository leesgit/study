package com.example.lbc.mfcproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lbc.mfcproject.adapter.contract.PointAdapterContract;
import com.example.lbc.mfcproject.adapter.holder.PointViewHolder;
import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.R;
import com.example.lbc.mfcproject.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbc on 2017-12-04.
 */

public class PointAdapter extends RecyclerView.Adapter<PointViewHolder> implements PointAdapterContract.Model,PointAdapterContract.View {
    List<Id> ids = new ArrayList<>();
    private OnItemClickListener onItemClickListener;


    public PointAdapter(List<Id> ids) {
        this.ids = ids;
    }

    @Override
    public PointViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.point_item, parent, false);
        PointViewHolder pointViewHolder = new PointViewHolder(view);
        return pointViewHolder;
    }

    @Override
    public void onBindViewHolder(PointViewHolder holder, int position) {
        holder.setData(position+1,ids.get(position));

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
