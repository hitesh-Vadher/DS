package com.example.myapplication.retrofit;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//public class RetrofitService {
//    private Retrofit retrofit;
//
//    public RetrofitService() {
//        initializeRetrofit();
//    }
//
//    private void initializeRetrofit() {
//        retrofit = new Retrofit.Builder()
//                .baseUrl("http://localhost:8080")
//                .addConverterFactory(GsonConverterFactory.create(new Gson()))
//                .build();
//    }
//
//    public Retrofit getRetrofit() {
//        return retrofit;
//    }
//}

public class RetrofitService {
    private static RetrofitService instance = null;
    private static ProductApi myApi;

    private RetrofitService() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ProductApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(ProductApi.class);
    }

    public static synchronized RetrofitService getInstance() {
        if (instance == null) {
            instance = new RetrofitService();
        }
        return instance;
    }

    public ProductApi getMyApi() {
        return myApi;
    }
}