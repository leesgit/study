package com.example.lkoon.movieboja.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lkoon.movieboja.R;
import com.example.lkoon.movieboja.adapter.ChatRoomRecyclerViewAdapter;
import com.example.lkoon.movieboja.model.ChatData;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lkoon on 2017-06-24.
 */

public class ChatRoomActivity extends AppCompatActivity {
    private LinearLayoutManager linearLayoutManager;
    private ChatRoomRecyclerViewAdapter viewAdapter;
    private List<ChatData> list;
    private SwipeRefreshLayout swipeRefreshLayout;
    TextView textViewTitle;
    Button btnInput;
    RecyclerView recyclerView;
    EditText editText;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_roomview);
        btnInput = (Button) findViewById(R.id.btnInput);
        editText = (EditText) findViewById(R.id.editText);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL)); //구분선

        list = new ArrayList<>();
        recyclerView.setAdapter(viewAdapter = new ChatRoomRecyclerViewAdapter("lee", list));
        //viewAdapter.notifyDataSetChanged();


        Intent intent = getIntent();
        final int num = intent.getExtras().getInt("Movie");

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message;
                message = editText.getText().toString();
//                ChatData chatData = new ChatData((list.size() % 2 == 0) ? "le" : "lee", message);
                ChatData chatData = new ChatData("lee", message);
//                list.add(chatData);
                editText.getText().clear();

                databaseReference.child("message").child(num +"").push().setValue(chatData);
            }
        });

        databaseReference.child("message").child(num+"").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //새 채팅이 왔을때

                ChatData chatData = dataSnapshot.getValue(ChatData.class);
                Log.e("챗 데이터 :", chatData.getMessage());
                list.add(chatData);
                viewAdapter.notifyDataSetChanged();
                linearLayoutManager.scrollToPosition(list.size() - 1);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//어떤사람이 데이터를 수정하면 그에대한 수정본이 내려옴
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        String title = null;
        switch (num) {
            case 1:
                title = "액션 영화 채팅방";
                break;
            case 2:
                title = "멜로 영화 채팅방";
                break;
            case 3:
                title = "느와르 영화 채팅방";
                break;
            case 4:
                title = "코메디 영화 채팅방";
                break;
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null && title != null) {
            actionBar.setTitle(title);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}
