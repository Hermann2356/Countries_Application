package com.example.countries_application.repo;

import com.example.countries_application.model.Country;
import com.example.countries_application.repo.remote.RetrofitInstance;

import java.util.Map;

import io.reactivex.Observable;

public class CountryRepo {
    public Observable<Country> getCountry(String name, Map<String, String> queryMap) {
        Observable<Country> countryObservable = RetrofitInstance.getCountryService()
                .getCountry(name, queryMap);

        return countryObservable;
    }
}
