package com.lbc.practice.toolbar;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); //타이틀 가림

        toolbar.findViewById(R.id.toolbar_email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"도착한 메시지가 없습니다.",Toast.LENGTH_SHORT).show();
            }
        });


        drawerLayout = (DrawerLayout)findViewById(R.id.main_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.first) {
                    getFragmentManager().beginTransaction().replace(R.id.main_frame,new FirstFragment() ).commit();
                }
                else if (item.getItemId()==R.id.second) {

                    getFragmentManager().beginTransaction().replace(R.id.main_frame,new SecondFragment() ).commit();
                }
                else if (item.getItemId()==R.id.third) {

                    getFragmentManager().beginTransaction().replace(R.id.main_frame,new ThirdFragment() ).commit();
                }
                drawerLayout.closeDrawer(GravityCompat.START);//왼쪽
                return false;
            }
        });
    }
}
