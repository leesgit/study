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
			"Authorization:key=" //Ű �� �Է��ϼžߵ˴ϴ�.
		})
		@POST("/fcm/send")
	    Call<SimpleResult> sendFcmMessage(@Body FcmAddress fcmadd);

}
