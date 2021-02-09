package com.example.countries_application.repo;

import com.example.countries_application.model.Country;
import com.example.countries_application.repo.remote.RetrofitInstance;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

public class CountryRepository {
    public Observable<List<Country>> getCountryByName(String name, Map<String, String> queryMap) {
        Observable<List<Country>> countryObservable = RetrofitInstance.getCountryService()
                .getCountryByName(name, queryMap);

        return countryObservable;
    }

    public Observable<List<Country>> getCountryByCurrency(String currency, Map<String, String> queryMap) {
        Observable<List<Country>> countryObservable = RetrofitInstance.getCountryService()
                .getCountryByCurrency(currency, queryMap);

        return countryObservable;
    }

    public Observable<List<Country>> getCountryByLanguage(String et, Map<String, String> queryMap) {
        Observable<List<Country>> countryObservable = RetrofitInstance.getCountryService()
                .getCountryByLanguage(et, queryMap);

        return countryObservable;
    }

    public Observable<List<Country>> getCountryByCapital(String capital, Map<String, String> queryMap) {
        Observable<List<Country>> countryObservable = RetrofitInstance.getCountryService()
                .getCountryByCapital(capital, queryMap);

        return countryObservable;
    }

    public Observable<List<Country>> getCountryByRegion(String region, Map<String, String> queryMap) {
        Observable<List<Country>> countryObservable = RetrofitInstance.getCountryService()
                .getCountryByRegion(region, queryMap);

        return countryObservable;
    }

    public Observable<List<Country>> getAllCountries(Map<String, String> queryMap) {
        Observable<List<Country>> countryObservable = RetrofitInstance.getCountryService()
                .getAllCountries(queryMap);

        return countryObservable;
    }
}
