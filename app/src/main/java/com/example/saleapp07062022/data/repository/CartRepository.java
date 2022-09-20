package com.example.saleapp07062022.data.repository;

import android.content.Context;

import com.example.saleapp07062022.data.remote.ApiService;
import com.example.saleapp07062022.data.remote.RetrofitClient;
import com.example.saleapp07062022.data.remote.dto.AppResponse;
import com.example.saleapp07062022.data.remote.dto.CartDTO;

import java.util.HashMap;

import retrofit2.Call;

public class CartRepository {
    private ApiService apiService;

    public CartRepository(Context context) {
        apiService = RetrofitClient.getInstance(context).getApiService();
    }

    public Call<AppResponse<CartDTO>> getCart() {
        return apiService.getCart();
    }

    public Call<AppResponse<CartDTO>> addCart(String idProduct) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id_product", idProduct);
        return apiService.addToCart(hashMap);
    }
}
