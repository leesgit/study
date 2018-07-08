package com.example.lkoon.movieboja.Interface;

import com.example.lkoon.movieboja.model.MovieResponse;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

 

public class RetrofitManager {
    private static RetrofitManager manager;
    private RetrofitUrl url;

    public static RetrofitManager getInstance(){
        if(manager == null)
            manager = new RetrofitManager();
        return manager;
    }

    public static void clearInstance(){
        manager = null;
    }

    private RetrofitManager(){
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(client)
                .build();
        url = retrofit.create(RetrofitUrl.class);
    }

    public RetrofitUrl getUrls(){
        return url;
    }

    public interface RetrofitUrl{
        String BASE_URL = "http://movie.daum.net";
        // FormUrlEncoded POST를 쓸때 넣어줘야됨
        @GET("/data/movie/movie_info/ticket_rank_no_mid.json")
        Call<MovieResponse> rankList(
                @Query("pageNo") int pageNo,
                @Query("pageSize") int pageSize
//http://movie.daum.net//data/movie/movie_info/ticket_rank_no_mid.json?pageNo=1?pageSize=1
//path {}안에 값 교체
        );
    }
}
