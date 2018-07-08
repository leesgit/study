package com.example.lkoon.movieboja.Interface;

import com.example.lkoon.movieboja.model.Address;
import com.example.lkoon.movieboja.model.CommentResult;
import com.example.lkoon.movieboja.model.SimpleResult;
import com.example.lkoon.movieboja.model.TheaterCommnents;
import com.example.lkoon.movieboja.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by lkoon on 2017-03-17.
 */

public interface UserService {
//    @GET("/user/{id}")
//    Call<User> getUser(@Path("id") int id);
//    @GET("/user/")
//    Call<List<User>>getUserList();
//    @GET("/usr/login/")
//    Call<User> getLogin(@Path("id") String id,@Path("passwd") String passwd);
//

    @POST("/fcm/send/")
    Call<SimpleResult> send(@Body Address address);

    @POST("/user/login/")
    Call<SimpleResult> login(@Body User user);

    @POST("/user/join/")
    Call<SimpleResult> join(@Body User user);

    @POST("/user/readcomment/")
    Call<CommentResult> coments(@Body TheaterCommnents tag);


//    @POST("/user/readcomment/")
//    Call<TheaterCommnents> readcomment()

//
//    @POST("/user/")
//    Call<User> createUser(@Body User user);
}
