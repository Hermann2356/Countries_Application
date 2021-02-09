package com.example.countries_application.repo.remote;

import com.example.countries_application.model.Country;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface CountryService {

    @GET("name/{name}")
    Observable<Country> getCountryByName(@Path("name") String name, @QueryMap Map<String, String> queryMap);

    @GET("currency/{currency}")
    Observable<Country> getCountryByCurrency(@Path("currency") String currency, @QueryMap Map<String, String> queryMap);

    @GET("lang/{et}")
    Observable<Country> getCountryByLanguage(@Path("et") String et, @QueryMap Map<String, String> queryMap);

    @GET("capital/{capital}")
    Observable<Country> getCountryByCapital(@Path("capital") String capital, @QueryMap Map<String, String> queryMap);

    @GET("region/{region}")
    Observable<Country> getCountryByRegion(@Path("region") String region, @QueryMap Map<String, String> queryMap);

    @GET("all")
    Observable<Country> getAllCountries(@QueryMap Map<String, String> queryMap);
}
