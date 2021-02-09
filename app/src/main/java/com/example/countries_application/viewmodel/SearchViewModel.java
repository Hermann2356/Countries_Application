package com.example.countries_application.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.countries_application.model.Country;
import com.example.countries_application.repo.CountryRepository;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchViewModel extends AndroidViewModel {
    private MutableLiveData<List<Country>> _country = new MutableLiveData<>();
    public SearchViewModel(@NonNull Application application) {

        super(application);
    }
    public LiveData<List<Country>> getCountry() {
        return _country;
    }

    public void fetchCountry(String name, Map<String, String> queryMap) {
        new CountryRepository().getCountryByName(name, queryMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Country>>() {
                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
                        Log.d("onSubcribe", "called");
                    }

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull List<Country> countries) {
                        Log.d("onNext", "called");
                        _country.setValue(countries);
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                        Log.d("onError", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("onComplete", "called");
                    }
                });
    }

}
