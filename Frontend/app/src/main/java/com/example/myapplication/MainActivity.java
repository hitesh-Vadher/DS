package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.myapplication.model.ProductModel;
import com.example.myapplication.adapter.ProductAdapter;
import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

import com.example.myapplication.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    GridView productsGV;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productsGV = findViewById(R.id.idGVProducts);


//        getAllProducts();

        Call<List<ProductModel>> call = RetrofitService.getInstance().getMyApi().getAllProducts();
        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                System.out.println(response);
                ArrayList<ProductModel> productModelArrayList = (ArrayList<ProductModel>) response.body();
                ProductAdapter adapter = new ProductAdapter( MainActivity.this, productModelArrayList);
//                productsGV.setAdapter(adapter);
                productsGV.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, (List<String>) adapter));
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occurred", Toast.LENGTH_LONG).show();
            }
        });
    }

//    private void getAllProducts() {
//        Call<List<ProductModel>> call = RetrofitService.getInstance().getMyApi().getAllProducts();
//        call.enqueue(new Callback<List<ProductModel>>() {
//            @Override
//            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
//                ArrayList<ProductModel> productModelArrayList = new ArrayList<ProductModel>();
//
//                productModelArrayList = (ArrayList<ProductModel>) response.body();
//                ProductAdapter adapter = new ProductAdapter(this, productModelArrayList);
//                productsGV.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
//            }
//        });
//    }

}