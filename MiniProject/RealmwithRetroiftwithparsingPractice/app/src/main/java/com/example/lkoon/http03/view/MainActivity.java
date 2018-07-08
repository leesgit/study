package com.example.lkoon.http03.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lkoon.http03.R;
import com.example.lkoon.http03.RetrofitManager;
import com.example.lkoon.http03.adapter.UserListAdapter;
import com.example.lkoon.http03.model.Word;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText input01;
    TextView txtMsg;
    TextView tvResult;
    Button index;
    Button btnAdd;
    Button btnDel;
    Realm realm;
    UserListAdapter listAdapter;
    ListView listView;
    ArrayList<Word> arrayList;

    public static String defaultUrl = "http://m.endic.naver.com/search.nhn?searchOption=entryIdiom&query=";
    public static String word = "";
    public static String wordSearch;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listWord);
        listAdapter = new UserListAdapter(getApplicationContext());
        input01 = (EditText) findViewById(R.id.input01);
        input01.setText(word);
        tvResult= (TextView)findViewById(R.id.tvResult);
        txtMsg = (TextView) findViewById(R.id.txtMsg);
        index =(Button)findViewById(R.id.index);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnDel = (Button)findViewById(R.id.btnDel);

        arrayList =new ArrayList();

        /////////
        Realm.init(this);
        //configuration 설정
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(realmConfiguration);
        //Realm 인스턴스를 얻는다.
        realm = Realm.getDefaultInstance();

        ////////////
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wordSearch==null){
                    Toast.makeText(getApplicationContext(),"단어 추가를 해주세요",Toast.LENGTH_LONG).show();
                }

                else {
                    //Realm 쓰기
                    try {
                        //뭔가 할것들
                        realm.beginTransaction();

                        //새 객체 생성
                        Word member = realm.createObject(Word.class);
                        member.setWord(wordSearch);
                        //List<Word> list=wordSearch;
                        Log.e("test", wordSearch);
                        arrayList.add(member);
                        Log.e("test", arrayList.get(0).getWord());


                        realm.commitTransaction();

                    } finally {
                        //       realm.close();
                    }
                }
            }
        });

        index.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                listAdapter.setList(arrayList);
                listView.setAdapter(listAdapter);

                RealmQuery<Word> query = realm.where(Word.class);
                //query.equalTo("name", "이순신");

                RealmResults<Word> results = query.findAllAsync();
                // 데이터가 변하면 리스너들에게 알림이 갑니다
                /*
                results.addChangeListener(new RealmChangeListener<RealmResults<Word>>() {
                    @Override
                    public void onChange(RealmResults<Word> results) {
                        tvResult.setText("");
                        // 질의 결과는 실시간으로 갱신됩니다
                        //results.size(); // => 1
                        Log.d("result: ", String.valueOf(results.size()));
                        for (Word m : results) {
                            String memberInfo = m.getWord()+ " \n ";
                            tvResult.append(memberInfo);

                        }
                    }
                });
                */

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // listAdapter.setList();


                int count;
                count = listAdapter.getCount();
                //Log.d("count",);
                while (count!=0){
                    --count;
                    arrayList.remove(count);
                    Log.e("Del", arrayList.size()+"");
                }
                listAdapter.notifyDataSetChanged();

                final RealmResults<Word> cResults = realm.where(Word.class).findAll();
                //데이터에 대한 모든 변경은 트랜잭션에서 이루어져야 한다.
                realm.executeTransaction(new Realm.Transaction(){
                    @Override
                    public void execute(Realm realm){
                        cResults.deleteAllFromRealm();
                    }
                });

            }
        });




        // 버튼 이벤트 처리
        Button requestBtn = (Button) findViewById(R.id.requestBtn);
        requestBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //String urlStr = defaultUrl+input01.getText().toString();
                String query = input01.getText().toString();

                //Ansy ansy = new Ansy();
                //ansy.execute(urlStr);
                RetrofitManager.getInstance().getUrl().search("entryIdiom",query)
                        .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if( response.raw().code() == 200 ){
                            ResponseBody body = response.body();
                            String source = null;
                            if( body != null ){
                                try {
                                    source = body.string();
                                }catch (Exception e){}
                            }
                            if( source != null ){
                                StringBuilder output = new StringBuilder();
                                BufferedReader reader = new BufferedReader(new StringReader(source));
                                String line = null;
                                try {
                                    boolean isSearch = false;
                                    while (true) {
                                        line = reader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        if (line.contains("section_card") && isSearch) {
                                            isSearch = false;
                                            break;
                                        }
                                        if (isSearch || line.contains("section_card")) {
                                            isSearch = true;
                                            if (line.contains("p class=\"desc\"")) {
                                                wordSearch = line.replace("<li> <p class=\"desc\">", "");
                                                wordSearch = wordSearch.replace("</p></li>", "");
                                                output.append(wordSearch + "\n");
                                            }
                                            continue;
                                        }
                                    }
                                }catch (Exception e){
                                    e.printStackTrace();
                                } finally {
                                    try{
                                        reader.close();
                                    }catch (Exception e){}
                                }
                                txtMsg.setText(output.toString());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("err","err",t);
                    }
                });

            }
        });

    }




//    public class Ansy extends AsyncTask<String,Integer,String>{
//
//        @Override
//        protected String doInBackground(String... params) {
//                StringBuilder output = new StringBuilder();
//                try {
//                    URL url = new URL(params[0]);
//                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//                    if (conn != null) {
//                        conn.setConnectTimeout(10000);
//                        conn.setRequestMethod("GET");
//                        conn.setDoInput(true);
//                        conn.setDoOutput(true);
//
//                        int resCode = conn.getResponseCode();
//
//                        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream())) ;
//                        String line = null;
//
//                        boolean isSearch= false;
//                        while(true) {
//                            line = reader.readLine();
//                            if (line == null) {
//                                break;
//                            }
//                            if(line.contains("section_card")&& isSearch){
//                                isSearch = false;
//                                break;
//                            }
//                            if (isSearch || line.contains("section_card"))
//                            {
//                                isSearch = true;
//                                if (line.contains("p class=\"desc\""))
//                                {
//
//                                    //output.append(line + "\n");
//                                    wordSearch = line.replace("<li> <p class=\"desc\">","");
//                                    wordSearch = wordSearch.replace("</p></li>","");
//                                    output.append(wordSearch + "\n");
//                                    //Log.e("line", line);
//
//
//
//                                }
//                                continue;
//                            }
//
//
//
//                        }
//
//                        reader.close();
//                        conn.disconnect();
//                    }
//                } catch(Exception ex) {
//                    Log.e("SampleHTTP", "Exception in processing response.", ex);
//                    ex.printStackTrace();
//                }
//
//            return output.toString();
//        }
//        protected void onProgressUpdate(Integer... progress){
//
//        }
//        protected void onPostExecute(String result){
//            super.onPostExecute(result);
//            txtMsg.setText(result);
//
//        }
//    }

}
