package com.example.lbc.mfcproject;

import com.example.lbc.mfcproject.data.Id;
import com.google.gson.Gson;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.List;

import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by lbc on 2017-11-30.
 */

public class RetrofitManager {

        private static RetrofitManager instance;
        private RetrofitUrl url;

        private RetrofitManager() {
            final CookieManager cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
            OkHttpClient client = new OkHttpClient.Builder()
                    .cookieJar(new JavaNetCookieJar(cookieManager))
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(RetrofitUrl.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .client(client)
                    .build();

            url = retrofit.create(RetrofitUrl.class);
        }

        public static RetrofitManager getInstance() {
            if (instance == null) {
                instance = new RetrofitManager();
            }
            return instance;
        }

        public static void clearInstance() {
            instance = null;
        }

        public RetrofitUrl getUrl() {
            return url;
        }

        public interface RetrofitUrl {
            String BASE_URL = "http://172.30.1.2:8080";


            @GET("/mfc/user/point/list")
            Call<List<Id>> point();

            @POST("/mfc/user/find")
            Call<List<Id>> search(@Body Id id);
        }

}
