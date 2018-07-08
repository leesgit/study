package com.example.lkoon.http03.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lkoon.http03.R;
import com.example.lkoon.http03.model.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lkoon on 2017-03-26.
 */

public class UserListAdapter extends BaseAdapter {

    private List<Word> list;
    private Context context;

    public UserListAdapter(List<Word> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public UserListAdapter(Context context){
        this.context = context;
        list = new ArrayList<>();
    }

    public void setList(List<Word> list){
        this.list = list;
        Log.e("sa", list.size()+"");
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {  //뷰 구성
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.wordTv.setText(list.get(i).getWord());

        return view;
    }


    public class ViewHolder {

       TextView wordTv;
        ViewHolder(View view) {
            wordTv = (TextView)view.findViewById(R.id.wordTv);

        }
    }
}
