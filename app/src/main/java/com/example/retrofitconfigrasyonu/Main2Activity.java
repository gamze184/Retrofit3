package com.example.retrofitconfigrasyonu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.retrofitconfigrasyonu.Models.Resault;
import com.example.retrofitconfigrasyonu.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    String id, postid;
    TextView postid2, id2, name2, body2, email2;
    List<Resault> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        al();
        istek();
        tanimla();
    }

    public void al() {
//diğer classtan veri çekme
        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        postid = bundle.getString("post id");

    }

    public void tanimla() {
        id2 = (TextView) findViewById(R.id.id2);
        name2 = (TextView) findViewById(R.id.name2);
        postid2 = (TextView) findViewById(R.id.postId2);
        email2 = (TextView) findViewById(R.id.email2);
        body2 = (TextView) findViewById(R.id.body2);

    }

    public void atama(List<Resault> list) {
        id2.setText("" + list.get(0).getId());
        name2.setText(list.get(0).getName());
        body2.setText(list.get(0).getBody());
        postid2.setText("" + list.get(0).getPostId());
        email2.setText(list.get(0).getEmail());

    }

    public void istek() {
        list = new ArrayList<>();


        Call<List<Resault>> call = ManagerAll.getInstance().ManagergetResault(postid, id);
        call.enqueue(new Callback<List<Resault>>() {
            @Override
            public void onResponse(Call<List<Resault>> call, Response<List<Resault>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    atama(list);
                }
            }

            @Override
            public void onFailure(Call<List<Resault>> call, Throwable t) {

            }
        });
    }
}
