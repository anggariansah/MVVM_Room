package com.anggariansah.mvvmroom.ui.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.anggariansah.mvvmroom.data.model.Mahasiswa;
import com.anggariansah.mvvmroom.data.repository.MahasiswaRepository;

import java.util.List;

public class DetailMahasiswaViewModel extends ViewModel {
    private MahasiswaRepository mahasiswaRepository;

    public DetailMahasiswaViewModel(Application application) {
        mahasiswaRepository = new MahasiswaRepository(application);

    }

    public LiveData<List<Mahasiswa>> getDetailMahasiswa(int id){
        return mahasiswaRepository.getDetail(id);
    }

    public void updateMahasiswa(int id,String nim, String nama, String kelas){
        mahasiswaRepository.update(getMock(id, nim, nama, kelas));
    }

    public void deleteMahasiswa(int id){
        mahasiswaRepository.delete(getMockId(id));
    }

    private Mahasiswa getMock(int id, String nim, String nama, String kelas){
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setId(id);
        mahasiswa.setNim(nim);
        mahasiswa.setNama(nama);
        mahasiswa.setKelas(kelas);
        return mahasiswa;
    }

    private Mahasiswa getMockId(int id){
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setId(id);
        return mahasiswa;
    }

}
