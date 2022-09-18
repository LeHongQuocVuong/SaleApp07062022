package com.example.saleapp07062022.data.repository;

import android.content.Context;

import com.example.saleapp07062022.data.remote.ApiService;
import com.example.saleapp07062022.data.remote.RetrofitClient;
import com.example.saleapp07062022.data.remote.dto.AppResponse;
import com.example.saleapp07062022.data.remote.dto.ProductDTO;

import java.util.List;

import retrofit2.Call;

public class ProductRepository {
    private ApiService apiService;

    public ProductRepository(Context context) {
        apiService = RetrofitClient.getInstance(context).getApiService();
    }

    public Call<AppResponse<List<ProductDTO>>> getProducts() {
        return apiService.getProducts();
    }
}
