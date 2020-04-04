package com.anggariansah.mvvmroom.utils;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.anggariansah.mvvmroom.ui.viewmodel.DetailMahasiswaViewModel;

public class DetailViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static DetailViewModelFactory viewModelFactory;
    private final Application mApplication;

    private DetailViewModelFactory(Application application){
        mApplication = application;
    }

    public static DetailViewModelFactory getInstance(Application application){
        if(viewModelFactory == null){
            viewModelFactory = new DetailViewModelFactory(application);
        }

        return viewModelFactory;
    }


    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DetailMahasiswaViewModel.class)){
            return (T) new DetailMahasiswaViewModel(mApplication);
        }
        return super.create(modelClass);
    }
}
