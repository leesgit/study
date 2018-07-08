package com.example.lkoon.movieboja.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lkoon.movieboja.R;
import com.example.lkoon.movieboja.model.MovieData;

import java.util.List;

/**
 * Created by jwk on 2017. 6. 21..
 */

public class ExRecyclerViewAdapter extends RecyclerView.Adapter<ExRecyclerViewHolder> {
    private List<MovieData> list;
    //띄울 내용들이 들어있는 List


    public ExRecyclerViewAdapter(List<MovieData> list){
        this.list = list;
    }

    @Override
    public ExRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //parent = 한칸한칸의 View들을 자식으로 가지는 부모View
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_content,parent,false);
        //R.layout.list_content의 모양을 View로 생성
        return new ExRecyclerViewHolder(v);
        //ViewHolder 생성 후 리턴
        //ViewHolder란 한칸에 대한 View를 관리하는 클래스


    }

    @Override
    public void onBindViewHolder(ExRecyclerViewHolder holder, int position) {
        //holder = onCreateViewHolder에서 생성해준 ViewHolder // position = 현재 몇번째 칸인지
        MovieData item = list.get(position);
        //list에서 해당 번째 item을 가져오기
        holder.setData(item);
        //ViewHolder에게 item을 건네주어 해당 번째에 맞는 내용을 잘표시하도록 함
    }

    @Override
    public int getItemCount() {
        return list.size(); // 총 몇개의 칸을 띄워야하는지
    }
}
