package com.example.lbc.mfcproject.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lbc.mfcproject.R;
import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.listener.OnItemClickListener;

/**
 * Created by lbc on 2017-12-10.
 */

public class SearchViewHolder extends RecyclerView.ViewHolder {
    TextView tvPoint, tvNick;
    private OnItemClickListener onItemClickListener;

    public SearchViewHolder(View itemView, OnItemClickListener onItemClickListener) {
        super(itemView);
        tvPoint =(TextView)itemView.findViewById(R.id.tvSearchPoint);
        tvNick =(TextView)itemView.findViewById(R.id.tvSearchNick);
        this.onItemClickListener = onItemClickListener;
    }

    public void setData(Id data,final int position) {
        tvPoint.setText(data.getPoint()+"");
        tvNick.setText(data.getId().toString());
        tvPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }
}
