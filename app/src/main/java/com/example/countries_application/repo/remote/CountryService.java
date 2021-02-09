package com.example.countries_application.repo.remote;

import com.example.countries_application.model.Country;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface CountryService {

    @GET("name/{name}")
    Observable<Country> getCountry(@Path("name") String name, @QueryMap Map<String, String> queryMap);
}
