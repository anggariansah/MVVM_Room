package com.anggariansah.mvvmroom.utils;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.anggariansah.mvvmroom.ui.viewmodel.MahasiswaViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static ViewModelFactory viewModelFactory;
    private final Application mApplication;

    private ViewModelFactory(Application application){
        mApplication = application;
    }

    public static ViewModelFactory getInstance(Application application){
        if(viewModelFactory == null){
            viewModelFactory = new ViewModelFactory(application);
        }

        return viewModelFactory;
    }


    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MahasiswaViewModel.class)){
            return (T) new MahasiswaViewModel(mApplication);
        }
        return super.create(modelClass);
    }
}
