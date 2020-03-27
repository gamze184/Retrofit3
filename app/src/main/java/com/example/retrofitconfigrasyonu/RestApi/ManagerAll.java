package com.example.retrofitconfigrasyonu.RestApi;

import com.example.retrofitconfigrasyonu.Models.Bilgiler;
import com.example.retrofitconfigrasyonu.Models.Resault;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance=new ManagerAll();
    public static synchronized  ManagerAll getInstance(){

        return ourInstance;
    }
   public Call<List<Bilgiler>>  getircall(){

        Call<List<Bilgiler>> x=getRestApi().getir();
        return x;
   }
   public Call<List<Resault>> ManagergetResault(String post,String id){
       Call<List<Resault>> y=getRestApi().getirResault(post,id);
       return y;

   }

}
