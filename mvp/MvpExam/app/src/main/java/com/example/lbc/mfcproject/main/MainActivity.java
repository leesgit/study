package com.example.lbc.mfcproject.main;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lbc.mfcproject.R;
import com.example.lbc.mfcproject.adapter.PageAdapter;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    View.OnClickListener buttonsClickListener;
    int[] buttonIds = {
            R.id.rankButton,
            R.id.searchButton,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        viewPager = (ViewPager)findViewById(R.id.club_viewPager);
        PageAdapter pagerAdapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        buttonsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = 0;
                index =buttonIds[0] ==v.getId() ?0 :buttonIds[1] ==v.getId() ? 1:0;
                Log.e("v.getid",index+"");
                viewPager.setCurrentItem(index);
            }
        };

        for(int id : buttonIds)
            findViewById(id).setOnClickListener(buttonsClickListener);


    }
}
