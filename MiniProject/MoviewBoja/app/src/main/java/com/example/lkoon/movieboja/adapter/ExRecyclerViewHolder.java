package com.example.lkoon.movieboja.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lkoon.movieboja.R;
import com.example.lkoon.movieboja.model.MovieData;

/**
 * Created by jwk on 2017. 6. 21..
 */

public class ExRecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView tvRank, tvTitle, tvTitleEn, tvAdmission, tvReleaseDate;
    private ImageView imageView;

    public ExRecyclerViewHolder(View v){
        super(v);
        tvRank = (TextView)v.findViewById(R.id.list_content_textview_num);
        imageView = (ImageView)v.findViewById(R.id.chatImage);
        tvTitle = (TextView)v.findViewById(R.id.list_content_textview_title);
        tvTitleEn = (TextView)v.findViewById(R.id.list_content_textview_title_en);
        tvAdmission = (TextView)v.findViewById(R.id.list_content_textview_title_admission);
        tvReleaseDate = (TextView)v.findViewById(R.id.list_content_textview_title_releaseDate);
    }

    public void setData(MovieData item){
        tvRank.setText(""+item.getRank().getRanking());
        if(item.getPhoto()!=null){
            Glide.with(imageView.getContext()).load(item.getPhoto().getFullname())
                    .fitCenter()
                    .into(imageView);

        }
        tvTitle.setText(item.getTitleKo());
        tvTitleEn.setText(item.getTitleEn());
        tvAdmission.setText(item.getAdmissionDesc());
        tvReleaseDate.setText(item.getReleaseDate());
    }
}
