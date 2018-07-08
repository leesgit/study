package com.example.lkoon.movieboja.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lkoon.movieboja.R;
import com.example.lkoon.movieboja.model.ChatRoom;

/**
 * Created by lkoon on 2017-07-01.
 */

public class LocalInfoRecyclerViewHolder extends RecyclerView.ViewHolder {

    private TextView textId;
    private TextView textComment;

    public LocalInfoRecyclerViewHolder(View itemView) {
        super(itemView);
        textId = (TextView)itemView.findViewById(R.id.textId);
        textComment = (TextView)itemView.findViewById(R.id.textComment);
    }

    public void setData(ChatRoom item){
        textId.setText(item.getList().get(item.getList().size()).getMessage());
        textComment.setText(item.getList().get(item.getList().size()).getMessage());

    }
}
