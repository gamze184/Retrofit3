package com.example.retrofitconfigrasyonu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.retrofitconfigrasyonu.Adapters.adapter;
import com.example.retrofitconfigrasyonu.Models.Bilgiler;
import com.example.retrofitconfigrasyonu.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Bilgiler> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        istek();
    }

    public void tanimla() {
        listView = (ListView) findViewById(R.id.listview);


    }

    public void istek() {
        list = new ArrayList<>();
        Call<List<Bilgiler>> call = ManagerAll.getInstance().getircall();
        call.enqueue(new Callback<List<Bilgiler>>() {
            @Override
            public void onResponse(Call<List<Bilgiler>> call, Response<List<Bilgiler>> response) {
                if (response.isSuccessful()) {
                    list = response.body();

                  adapter adapter=new adapter(list,getApplicationContext(),MainActivity.this);
                  listView.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<List<Bilgiler>> call, Throwable t) {

            }
        });

    }
}
