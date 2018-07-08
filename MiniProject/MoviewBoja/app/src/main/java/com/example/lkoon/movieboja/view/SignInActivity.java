package com.example.lkoon.movieboja.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lkoon.movieboja.R;
import com.example.lkoon.movieboja.data.source.UserRepository;
import com.example.lkoon.movieboja.listener.OnItemClickListener;
import com.example.lkoon.movieboja.presenter.MovieBojaContract;
import com.example.lkoon.movieboja.presenter.MovieBojaPresenter;

/**
 * Created by lkoon on 2017-06-23.
 */

public class SignInActivity extends AppCompatActivity implements MovieBojaContract.View{

    Button btnLogin;
    Button btnJoin;
    EditText editId;
    EditText editPass;
    String result;
    TextView tv;

    MovieBojaContract.Presenter presenter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        init();
        initView();
    }

    private void init() {
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnJoin = (Button)findViewById(R.id.btnJoin1);
        editPass = (EditText)findViewById(R.id.editPass);
        editId=(EditText)findViewById(R.id.editId);
    }

    private void initView(){
        presenter = new MovieBojaPresenter(this, new UserRepository());

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editId.getText().toString();
                String pw = editPass.getText().toString();
                presenter.sendIdAndPasswordToServer(id, pw, SignInActivity.this);
            }
        });

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,JoinActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

}