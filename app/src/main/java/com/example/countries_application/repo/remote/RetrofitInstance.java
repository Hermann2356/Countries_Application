package com.example.countries_application.repo.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitInstance {

    private static final String BASE_URL = "https://restcountries.eu/rest/v2/";

    private static CountryService INSTANCE = null;

    private RetrofitInstance() {

    }

    private static Retrofit getRetroFit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .client(getClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }



    public static CountryService getCountryService() {
        if (INSTANCE == null) {
            INSTANCE = getRetroFit()
                    .create(CountryService.class);

        }
        return INSTANCE;
    }

    private static OkHttpClient getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
    }
}
