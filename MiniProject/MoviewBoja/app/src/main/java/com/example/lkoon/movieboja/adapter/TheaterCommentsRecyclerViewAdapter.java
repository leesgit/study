package com.example.lkoon.movieboja.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lkoon.movieboja.R;
import com.example.lkoon.movieboja.model.TheaterCommnents;

import java.util.List;

/**
 * Created by lkoon on 2017-07-11.
 */

public class TheaterCommentsRecyclerViewAdapter extends RecyclerView.Adapter<TheaterCommentsRecyclerViewHolder>{


    private List<TheaterCommnents> list;

    public TheaterCommentsRecyclerViewAdapter(List<TheaterCommnents> list) {
        this.list = list;
    }

    @Override
    public TheaterCommentsRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comments,parent,false);
        return  new TheaterCommentsRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TheaterCommentsRecyclerViewHolder holder, int position) {
        TheaterCommnents item = list.get(position);
        holder.setData(item);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
