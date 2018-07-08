package com.kpu.mfc.controller;

import javax.inject.Inject;


import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpu.mfc.domain.Address;
import com.kpu.mfc.domain.FcmAddress;
import com.kpu.mfc.domain.SimpleResult;
import com.kpu.mfc.service.UserService;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RestController
@RequestMapping("/fcm")
public class FcmController {
	
	@Inject
	UserService service;
	
	@RequestMapping(path="/send")
	public String sendfcm(@RequestBody Address address) throws Exception{
		

		Retrofit retrofit;
		OkHttpClient okHttpClient;
		okHttpClient = new OkHttpClient();
        retrofit = new Retrofit.Builder().client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).baseUrl
                ("https://fcm.googleapis.com/").build();
        FcmAddress fcmaddress = new FcmAddress();
        fcmaddress.setMessage(address.message);
        fcmaddress.setTo("/topics/notice");
        FcmService fcmservice;
        fcmservice = retrofit.create(FcmService.class);
        fcmservice.sendFcmMessage(fcmaddress).enqueue(new Callback<SimpleResult>() {

			@Override
			public void onFailure(Call<SimpleResult> arg0, Throwable arg1) {
				// TODO Auto-generated method stub
				arg1.printStackTrace();
				}

			@Override
			public void onResponse(Call<SimpleResult> arg0, Response<SimpleResult> arg1) {
				// TODO Auto-generated method stub
				System.out.println(arg1.code() + " Code");
				System.out.println(arg1.body().message_id + " log");
				
			}
        });
        
       
		System.out.println(address.message);
		return address.message;
	}

}
