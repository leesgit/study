package com.kpu.mfc.controller;

import com.kpu.mfc.domain.FcmAddress;
import com.kpu.mfc.domain.SimpleResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface FcmService {
		@Headers({
			"Content-Type:application/json",
			"Authorization:key=" //키 값 입력하셔야됩니다.
		})
		@POST("/fcm/send")
	    Call<SimpleResult> sendFcmMessage(@Body FcmAddress fcmadd);

}
