package com.anggariansah.mvvmroom.ui.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.anggariansah.mvvmroom.data.model.Mahasiswa;
import com.anggariansah.mvvmroom.data.repository.MahasiswaRepository;

import java.util.List;

public class MahasiswaViewModel extends ViewModel {

    private MahasiswaRepository mahasiswaRepository;

    public MahasiswaViewModel(Application application) {
        mahasiswaRepository = new MahasiswaRepository(application);

    }

    public LiveData<List<Mahasiswa>> getAllMahasiswa(){
        return mahasiswaRepository.getAllMahasiswa();
    }



}
