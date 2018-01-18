package com.lbc.practice.cardview;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lbc on 2018-01-17.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<CardViewItemDTO> cardViewItemDTOS = new ArrayList<>();
    public MyRecyclerViewAdapter() {
        cardViewItemDTOS.add(new CardViewItemDTO(R.drawable.ic_android_black_24dp,"첫번째","이미지1"));
        cardViewItemDTOS.add(new CardViewItemDTO(R.drawable.ic_audiotrack_black_24dp,"두번째","이미지2"));
        cardViewItemDTOS.add(new CardViewItemDTO(R.drawable.ic_insert_emoticon_black_24dp,"세번째","이미지3"));

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //xml 세팅
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item,parent,false);
        return new RowCell(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //아이템 세팅
        ((RowCell)holder).imageView.setImageResource(cardViewItemDTOS.get(position).image);
        ((RowCell)holder).title.setText(cardViewItemDTOS.get(position).title);
        ((RowCell)holder).subtitle.setText(cardViewItemDTOS.get(position).subtitle);

    }

    @Override
    public int getItemCount() {
        return cardViewItemDTOS.size();
    }

    private class RowCell extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView title;
        public TextView subtitle;


        public RowCell(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.image);
            title =(TextView)itemView.findViewById(R.id.title);
            subtitle =(TextView)itemView.findViewById(R.id.subtitle);

        }

    }
}
