package com.example.lkoon.movieboja.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lkoon.movieboja.R;

/**
 * Created by lkoon on 2017-06-24.
 */

public class ChatActivity extends AppCompatActivity {
    Button btnAtion;
    Button btnMelo;
    Button btnNoir;
    Button btnComedy;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatview);
        btnAtion = (Button)findViewById(R.id.btnAction);
        btnMelo = (Button)findViewById(R.id.btnMelo);
        btnNoir = (Button)findViewById(R.id.btnNoir);
        btnComedy= (Button)findViewById(R.id.btnComedy);

        btnAtion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, ChatRoomActivity.class);
                intent.putExtra("Movie", 1);
                startActivity(intent);

            }
        });

        btnMelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, ChatRoomActivity.class);
                intent.putExtra("Movie", 2);
                startActivity(intent);
            }
        });

        btnNoir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, ChatRoomActivity.class);
                intent.putExtra("Movie", 3);
                startActivity(intent);
            }
        });

        btnComedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, ChatRoomActivity.class);
                intent.putExtra("Movie", 4);
                startActivity(intent);
            }
        });


    }
}
