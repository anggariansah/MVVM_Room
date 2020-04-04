package com.anggariansah.mvvmroom.ui.viewmodel;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.anggariansah.mvvmroom.data.model.Mahasiswa;
import com.anggariansah.mvvmroom.data.repository.MahasiswaRepository;

public class AddMahasiswaViewModel extends ViewModel {

    private MahasiswaRepository mahasiswaRepository;

    public AddMahasiswaViewModel(Application application) {
        mahasiswaRepository = new MahasiswaRepository(application);
    }

    public void insertMahasiswa(String nim, String nama, String kelas){
        mahasiswaRepository.insert(getMock(nim, nama, kelas));
    }


    private Mahasiswa getMock(String nim, String nama, String kelas){
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNim(nim);
        mahasiswa.setNama(nama);
        mahasiswa.setKelas(kelas);
        return mahasiswa;
    }
}
