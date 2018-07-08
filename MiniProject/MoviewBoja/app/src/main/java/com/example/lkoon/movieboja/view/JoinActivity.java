package com.example.lkoon.movieboja.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lkoon.movieboja.R;
import com.example.lkoon.movieboja.data.source.UserRepository;
import com.example.lkoon.movieboja.presenter.MovieBojaContract;
import com.example.lkoon.movieboja.presenter.MovieBojaPresenter;

/**
 * Created by lkoon on 2017-03-10.
 */

public class JoinActivity extends AppCompatActivity implements MovieBojaContract.View {
    Button bntJoin;
    EditText editID;
    EditText editName;
    EditText editPasswd;
    EditText editPhone;
    EditText editEmail;

    MovieBojaContract.Presenter presenter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        bntJoin = (Button)findViewById(R.id.btnJoin);
        editID = (EditText)findViewById(R.id.editID);
        editName = (EditText)findViewById(R.id.editName);
        editPasswd = (EditText)findViewById(R.id.editPssswd);
        editPhone = (EditText)findViewById(R.id.editPhone);
        editEmail= (EditText)findViewById(R.id.editEmail);

        presenter = new MovieBojaPresenter(this,new UserRepository());

        bntJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("edit",editID.getText().toString());

                }
        });
    }


    @Override
    public void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}



















/*
    public class Ansy extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... params) {
            OkHttpClient client = new OkHttpClient();
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("name",params[0]);
                jsonObject.put("id",params[1]);
                jsonObject.put("passwd",params[2]);
                jsonObject.put("phone",params[3]);
                jsonObject.put("email",params[4]);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),jsonObject.toString());
            Request request =new Request.Builder().url("http://150.95.135.222:1337/user").post(body).build();
            try {
                Response response = client.newCall(request).execute();
                Log.e("result",response.body().toString());
                return response.body().toString();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        }
        protected void onPostExecute(String result) {

            super.onPostExecute(result);

            if (result==null){
                Toast.makeText(getApplicationContext(),"알수 없는 오류 발생",Toast.LENGTH_LONG).show();
            }
            try {
                JSONObject jsonObject = new JSONObject(result);
                int resCode =jsonObject.getInt("resCode");
                String msg = jsonObject.getString("msg");
                switch (resCode){
                    case RES_OK : Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                        finish();
                        break;
                    case RES_NO : Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                        break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

 */