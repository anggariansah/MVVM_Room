package com.anggariansah.mvvmroom.utils;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.anggariansah.mvvmroom.ui.viewmodel.AddMahasiswaViewModel;

public class AddViewModelFactory extends ViewModelProvider.NewInstanceFactory  {

    private static AddViewModelFactory viewModelFactory;
    private final Application mApplication;

    private AddViewModelFactory(Application application){
        mApplication = application;
    }

    public static AddViewModelFactory getInstance(Application application){
        if(viewModelFactory == null){
            viewModelFactory = new AddViewModelFactory(application);
        }

        return viewModelFactory;
    }


    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AddMahasiswaViewModel.class)){
            return (T) new AddMahasiswaViewModel(mApplication);
        }
        return super.create(modelClass);
    }
}
