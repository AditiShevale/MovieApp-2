package com.example.aditi.movieapp.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.aditi.movieapp.Model.Movies.MoviesResult;
import com.example.aditi.movieapp.Repository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private LiveData<List<MoviesResult>> mData;
    private LiveData<List<MoviesResult>> mDataFav;
    private Repository mRespository;

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("xyz","Data cleared");
    }

    public MainViewModel(@NonNull Application application) {
        super(application);


        mRespository = new Repository(application);

    }

    public LiveData<List<MoviesResult>> mLiveData() {
        mData = mRespository.mLiveData();
        return mData;
    }

    public LiveData<List<MoviesResult>> mLiveDataFav() {
        if (mDataFav == null) {
            mDataFav = new MutableLiveData<>();
        }
        mDataFav = mRespository.mLiveDataFav();
        return mDataFav;
    }


    public void getTopRated() {
        mRespository.getTopRated();
    }

    public void getPopular() {
        mRespository.getPopular();
    }

    public void getFavData() {
        mRespository.getFavData();


    }

    public void deleteData(int id) {

        mRespository.deleteData(id);
    }
}

