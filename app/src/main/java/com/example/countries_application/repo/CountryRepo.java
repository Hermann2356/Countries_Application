package com.example.countries_application.repo;

import com.example.countries_application.model.Country;
import com.example.countries_application.repo.remote.RetrofitInstance;

import java.util.Map;

import io.reactivex.Observable;

public class CountryRepo {
    public Observable<Country> getCountryByName(String name, Map<String, String> queryMap) {
        Observable<Country> countryObservable = RetrofitInstance.getCountryService()
                .getCountryByName(name, queryMap);

        return countryObservable;
    }

    public Observable<Country> getCountryByCurrency(String currency, Map<String, String> queryMap) {
        Observable<Country> countryObservable = RetrofitInstance.getCountryService()
                .getCountryByCurrency(currency, queryMap);

        return countryObservable;
    }

    public Observable<Country> getCountryByLanguage(String et, Map<String, String> queryMap) {
        Observable<Country> countryObservable = RetrofitInstance.getCountryService()
                .getCountryByLanguage(et, queryMap);

        return countryObservable;
    }

    public Observable<Country> getCountryByCapital(String capital, Map<String, String> queryMap) {
        Observable<Country> countryObservable = RetrofitInstance.getCountryService()
                .getCountryByCapital(capital, queryMap);

        return countryObservable;
    }

    public Observable<Country> getCountryByRegion(String region, Map<String, String> queryMap) {
        Observable<Country> countryObservable = RetrofitInstance.getCountryService()
                .getCountryByRegion(region, queryMap);

        return countryObservable;
    }

    public Observable<Country> getAllCountries(Map<String, String> queryMap) {
        Observable<Country> countryObservable = RetrofitInstance.getCountryService()
                .getAllCountries(queryMap);

        return countryObservable;
    }
}
