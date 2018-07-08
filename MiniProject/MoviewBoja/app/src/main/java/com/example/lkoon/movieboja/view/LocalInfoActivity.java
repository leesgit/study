package com.example.lkoon.movieboja.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lkoon.movieboja.Interface.UserService;
import com.example.lkoon.movieboja.R;
import com.example.lkoon.movieboja.adapter.TheaterCommentsRecyclerViewAdapter;
import com.example.lkoon.movieboja.model.CommentResult;
import com.example.lkoon.movieboja.model.TheaterCommnents;
import com.example.lkoon.movieboja.model.User;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lkoon on 2017-06-25.
 */

public class LocalInfoActivity extends AppCompatActivity {
    OkHttpClient okHttpClient;
    UserService userService;
    User user;
    Retrofit retrofit;
    TextView textView;
    Button btnCommentInput;
    private TheaterCommentsRecyclerViewAdapter viewAdapter;
    List<TheaterCommnents> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_info);
        textView = (TextView) findViewById(R.id.textView);
        btnCommentInput = (Button) findViewById(R.id.btnCommentInput);

        Intent intent = getIntent();
        int num = intent.getExtras().getInt("number");
        String name = intent.getExtras().getString("name");
        textView.setText("번호" + num + "이름" + name);

        list = new ArrayList<>();
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setAdapter(viewAdapter = new TheaterCommentsRecyclerViewAdapter(list));


        okHttpClient = new OkHttpClient();
        retrofit = new Retrofit.Builder().client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).baseUrl
                ("http://192.168.43.38:8080/user/readcommnet/").build();
        userService = retrofit.create(UserService.class);

        final TheaterCommnents theaterCommnents = new TheaterCommnents(num);

        userService.coments(theaterCommnents).enqueue(new Callback<CommentResult>() {
            @Override
            public void onResponse(Call<CommentResult> call, retrofit2.Response<CommentResult> response) {
                CommentResult result = response.body();
//                list.addAll(result.getData());
//                Log.e("가져오기",result.getData().toString()+theaterCommnents.getTag());

                viewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CommentResult> call, Throwable t) {
            }
        });


        btnCommentInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });

    }
}
