package com.example.lkoon.movieboja.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lkoon.movieboja.R;
import com.example.lkoon.movieboja.model.ChatData;

/**
 * Created by lkoon on 2017-06-27.
 */

public class ChatRoomRecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView chatContents;

        public ChatRoomRecyclerViewHolder(View itemView) {
                super(itemView);
                chatContents = (TextView)itemView.findViewById(R.id.list_chat_contentr_textview_message);
        }

public void setData(ChatData item){
        chatContents.setText(item.getMessage());
        }
}
