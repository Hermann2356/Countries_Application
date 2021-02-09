package com.example.countries_application.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.countries_application.R;
import com.example.countries_application.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity {
    private ActivitySearchBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}