package com.example.saleapp07062022.presentation.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.saleapp07062022.R;
import com.example.saleapp07062022.data.model.AppResource;
import com.example.saleapp07062022.data.model.Product;
import com.example.saleapp07062022.databinding.ActivityHomeBinding;
import com.example.saleapp07062022.databinding.ActivitySignInBinding;
import com.example.saleapp07062022.presentation.view.adapter.ProductAdapter;
import com.example.saleapp07062022.presentation.viewmodel.HomeViewModel;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    HomeViewModel homeViewModel;
    ActivityHomeBinding binding;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        homeViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new HomeViewModel(HomeActivity.this);
            }
        }).get(HomeViewModel.class);

        initData();
        observerData();
        event();
    }

    private void initData() {
        productAdapter = new ProductAdapter();
        binding.recyclerViewProduct.setAdapter(productAdapter);
        binding.recyclerViewProduct.setHasFixedSize(true);
    }

    private void event() {
        homeViewModel.getProducts();
    }

    private void observerData() {
        homeViewModel.getResourceListProducts().observe(this, new Observer<AppResource<List<Product>>>() {
            @Override
            public void onChanged(AppResource<List<Product>> listAppResource) {
                switch (listAppResource.status) {
                    case SUCCESS:
                        productAdapter.updateListProduct(listAppResource.data);
                        setLoading(false);
                        break;
                    case LOADING:
                        setLoading(true);
                        break;
                    case ERROR:
                        Toast.makeText(HomeActivity.this, listAppResource.message, Toast.LENGTH_SHORT).show();
                        setLoading(false);
                        break;
                }
            }
        });
    }

    private void setLoading(Boolean isLoading) {
        if (isLoading) {
            binding.layoutLoading.getRoot().setVisibility(View.VISIBLE);
        } else {
            binding.layoutLoading.getRoot().setVisibility(View.GONE);
        }
    }
}