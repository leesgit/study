package com.example.lkoon.movieboja.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lkoon.movieboja.R;
import com.example.lkoon.movieboja.model.CommentView;

import java.util.List;

/**
 * Created by lkoon on 2017-07-01.
 */

public class LocalInfoRecyclerViewAdapter extends RecyclerView.Adapter<LocalInfoRecyclerViewHolder> {

    private List<CommentView> list;

    public LocalInfoRecyclerViewAdapter(List<CommentView> list) {
    }

    @Override
    public LocalInfoRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comments,parent,false);
        //R.layout.list_content의 모양을 View로 생성
        return new LocalInfoRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LocalInfoRecyclerViewHolder holder, int position) {

        //holder = onCreateViewHolder에서 생성해준 ViewHolder // position = 현재 몇번째 칸인지
        CommentView item = list.get(position);
        //list에서 해당 번째 item을 가져오기
//        holder.setData(item);
        //ViewHolder에게 item을 건네주어 해당 번째에 맞는 내용을 잘표시하도록 함

    }


    @Override
    public int getItemCount() {
        return 0;
    }
}
