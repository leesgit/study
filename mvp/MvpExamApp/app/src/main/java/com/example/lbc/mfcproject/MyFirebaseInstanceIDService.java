package com.example.lbc.mfcproject;


import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessaging;

/**
 * Created by lbc on 2017-12-07.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = "FirebaseMsgService";
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);


        FirebaseMessaging.getInstance().subscribeToTopic("/topics/notice");


        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.

        //eNOr-xR3vnk:APA91bEy3D0IT_gud3ToueN9RbnMo1loTYfuMtZ4eap5Vf0OaYWqeYGwf-ndrU6QFR59VnFBO1FZT1j1o62DhwC31xCC562oK66y5ciRN1Mc9u4vObwo03BTnDxfBAanl1yPcjO8NIWn
    }
}
