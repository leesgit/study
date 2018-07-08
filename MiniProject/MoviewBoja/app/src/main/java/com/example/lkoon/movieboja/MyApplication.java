package com.example.lkoon.movieboja;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.bumptech.glide.MemoryCategory;

/**
 * Created by lkoon on 2017-06-23.
 */

public class MyApplication extends Application {
    //안드로이드 앱을 불러올때 초기설정을 하기 위해서 사용 메니페스트에 name으로 추가해줘야된다.
    //이거 대신 스태틱으로 사용하기도 한다.
    @Override
    public void onCreate() {
        super.onCreate();
        Glide.get(this).setMemoryCategory(MemoryCategory.HIGH);

    }
}
