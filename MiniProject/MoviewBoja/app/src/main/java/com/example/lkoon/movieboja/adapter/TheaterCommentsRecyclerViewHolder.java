package com.example.lkoon.movieboja.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lkoon.movieboja.R;
import com.example.lkoon.movieboja.model.TheaterCommnents;

/**
 * Created by lkoon on 2017-07-11.
 */

public class TheaterCommentsRecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView textComment;
    private TextView textId;
    public TheaterCommentsRecyclerViewHolder(View itemView) {
        super(itemView);
        textComment = (TextView)itemView.findViewById(R.id.textComment);
        textId = (TextView)itemView.findViewById(R.id.textId);
    }
    public void setData(TheaterCommnents theaterCommnents){
        textComment.setText(theaterCommnents.getCommnet());
        textId.setText(theaterCommnents.getId());
    }
}
