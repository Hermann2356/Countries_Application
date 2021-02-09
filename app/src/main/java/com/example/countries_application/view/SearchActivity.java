package com.example.countries_application.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.countries_application.R;
import com.example.countries_application.adapter.CountryAdapter;
import com.example.countries_application.adapter.CountryClickListener;
import com.example.countries_application.databinding.ActivitySearchBinding;
import com.example.countries_application.model.Country;
import com.example.countries_application.viewmodel.SearchViewModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchActivity extends AppCompatActivity implements CountryClickListener {
    private ActivitySearchBinding binding;
    private SearchViewModel viewModel;

    private Map<String, String> queryMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        viewModel.fetchCountry("haiti", new HashMap<String, String>());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(binding.rvCountryList.getContext(), 3);
        binding.rvCountryList.setLayoutManager(gridLayoutManager);

        queryMap = new HashMap<>();
        Log.d("!", "Reached it");
        viewModel.getCountry().observe(this, new Observer<List<Country>>() {
            @Override
            public void onChanged(List<Country> countries) {
               CountryAdapter adapter = new CountryAdapter(countries, SearchActivity.this::itemClicked);
                binding.rvCountryList.setAdapter(adapter);
            }
        });

        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 2) {
                    Log.e("Action", "GO Performed");
                    String searchString = null;

                    if (binding.etSearch.getText() != null)
                        searchString = s.toString();

                    if (searchString != null && !searchString.isEmpty())
                        viewModel.fetchCountry(searchString, queryMap);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


//        binding.etSearch.setOnEditorActionListener((view, actionId, event) -> {
//            if (actionId == EditorInfo.IME_ACTION_GO) {
//                Log.d("Action", "GO Performed");
//                String searchString = null;
//
//                if (binding.etSearch.getText() != null)
//                    searchString = binding.etSearch.getText().toString();
//
//                if (searchString != null && !searchString.isEmpty())
//                    viewModel.fetchCountry(searchString, queryMap);
//
//                return true;
//            }
//
//            return false;
//        });
    }


    @Override
    public void itemClicked(Country country) {

    }
}