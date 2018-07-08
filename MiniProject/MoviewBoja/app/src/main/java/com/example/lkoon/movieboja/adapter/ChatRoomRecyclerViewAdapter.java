package com.example.lkoon.movieboja.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lkoon.movieboja.R;
import com.example.lkoon.movieboja.model.ChatData;

import java.util.List;

/**
 * Created by lkoon on 2017-06-27.
 */

public class ChatRoomRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String myUsername;
    private List<ChatData> list;

    private final static int TYPE_YOU = 1;
    private final static int TYPE_ME = 2;

    public ChatRoomRecyclerViewAdapter(String myUsername, List<ChatData> list) {
        this.myUsername = myUsername;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        ChatData item = list.get(position);
        if(item.getUsername().equals(myUsername))
            return TYPE_ME;
        else
            return TYPE_YOU;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View v;
        switch (viewType){
            case TYPE_YOU:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_chat_contentr,parent,false);
                viewHolder = new ChatRoomRecyclerViewHolderRecieve(v);
                break;
            case TYPE_ME:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_chat_contents,parent,false);
                viewHolder = new ChatRoomRecyclerViewHolder(v);
                break;
        }

        Log.e("list size","size = "+list.size());
        //R.layout.list_content의 모양을 View로 생성
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChatData item = list.get(position);
        if( holder instanceof ChatRoomRecyclerViewHolderRecieve ){
            ((ChatRoomRecyclerViewHolderRecieve) holder).setData(item);
        }else if( holder instanceof ChatRoomRecyclerViewHolder ){
            ((ChatRoomRecyclerViewHolder) holder).setData(item);
        }
        //holder = onCreateViewHolder에서 생성해준 ViewHolder // position = 현재 몇번째 칸인지
        //list에서 해당 번째 item을 가져오기
        //ViewHolder에게 item을 건네주어 해당 번째에 맞는 내용을 잘표시하도록 함
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
