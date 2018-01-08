package com.example.lbc.mfcproject.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.R;
import com.example.lbc.mfcproject.listener.OnItemClickListener;

import butterknife.OnClick;

/**
 * Created by lbc on 2017-12-04.
 */

public class PointViewHolder extends RecyclerView.ViewHolder {
    TextView tvRank, tvPoint, tvNick;



    public PointViewHolder(View itemView) {
        super(itemView);
        tvRank = (TextView)itemView.findViewById(R.id.tvRank);
        tvPoint = (TextView)itemView.findViewById(R.id.tvPoint);
        tvNick = (TextView)itemView.findViewById(R.id.tvNick);
    }

    public void setData(int rank, Id data) {
        int textSize = (rank < 4) ? 30 : 14;

        tvRank.setTextSize(textSize);
        tvPoint.setTextSize(textSize);
        tvNick.setTextSize(textSize);

        tvRank.setText(rank+"");
        tvPoint.setText("        "+data.getPoint()+"");
        tvNick.setText(data.getId());
        rank++;


    }
}
