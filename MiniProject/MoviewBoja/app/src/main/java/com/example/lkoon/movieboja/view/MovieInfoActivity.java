package com.example.lkoon.movieboja.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.lkoon.movieboja.Interface.RetrofitManager;
import com.example.lkoon.movieboja.R;
import com.example.lkoon.movieboja.adapter.ExRecyclerViewAdapter;
import com.example.lkoon.movieboja.model.MovieData;
import com.example.lkoon.movieboja.model.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lkoon on 2017-06-24.
 */

public class MovieInfoActivity extends AppCompatActivity implements Callback<MovieResponse>
{
    private LinearLayoutManager linearLayoutManager;
    private ExRecyclerViewAdapter viewAdapter;
    private List<MovieData> list;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_movielist);

//        ImageView imageView = (ImageView)findViewById(R.id.image1);
//        Glide.with(this).load("https://raw.githubusercontent.com/bumptech/glide/master/static/glide_logo.png")
//                .fitCenter().into(imageView);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL)); //구분선

        list = new ArrayList<>();
        recyclerView.setAdapter(viewAdapter = new ExRecyclerViewAdapter(list));
        RetrofitManager.getInstance().getUrls().rankList(1,10).enqueue(this);

        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.activity_main);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                viewAdapter.notifyDataSetChanged();
                RetrofitManager.getInstance().getUrls().rankList(1,10).enqueue(MovieInfoActivity.this);
            }
        });
    }
    @Override
    public void onResponse(Call<MovieResponse> call/*들어간거*/, Response<MovieResponse> response/*반환된거*/) {
        MovieResponse movieResponse = response.body();
        if(movieResponse!=null){
            list.addAll(movieResponse.getData());
            viewAdapter.notifyDataSetChanged();
            Log.e("test",""+movieResponse.toString());
        }else {
            Log.e("Retrofit", "ranklisy body empty");
            swipeRefreshLayout.setRefreshing(false);
        }

    }

    @Override
    public void onFailure(Call<MovieResponse> call, Throwable t) {
        Log.e("Retrofit","ranklist",t);
        swipeRefreshLayout.setRefreshing(false);

    }
}
