package com.example.lkoon.http03;

import java.net.CookieManager;
import java.net.CookiePolicy;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jwk on 2017. 9. 9..
 */

public class RetrofitManager {
    private static RetrofitManager instance;
    private RetrofitUrl url;
    private RetrofitManager(){
        final CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        OkHttpClient client = new OkHttpClient.Builder()
                .cookieJar(new JavaNetCookieJar(cookieManager))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitUrl.BASE_URL)
                //.addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(client)
                .build();
        url = retrofit.create(RetrofitUrl.class);
    }
    public static RetrofitManager getInstance(){
        if( instance == null ){
            instance = new RetrofitManager();
        }
        return instance;
    }
    public static void clearInstance(){
        instance = null;
    }

    public RetrofitUrl getUrl(){
        return url;
    }

    public interface RetrofitUrl{
        String BASE_URL = "http://m.endic.naver.com";

        @GET("/search.nhn")
        Call<ResponseBody> search(@Query("searchOption") String entryIdiom, @Query("query") String query);
    }
}
