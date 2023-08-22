package com.example.myapplication.retrofit;
import com.example.myapplication.model.ProductModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ProductApi {
    String BASE_URL = "http://localhost:8080";
    @GET("/products/all")
    Call<List<ProductModel>> getAllProducts();
}
