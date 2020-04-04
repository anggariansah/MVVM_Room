package com.anggariansah.mvvmroom.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.anggariansah.mvvmroom.data.dao.MahasiswaDao;
import com.anggariansah.mvvmroom.data.db.MahasiswaDb;
import com.anggariansah.mvvmroom.data.model.Mahasiswa;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MahasiswaRepository {

    private MahasiswaDao mahasiswaDao;
    private ExecutorService executorService;


    public MahasiswaRepository(Application application) {
        MahasiswaDb db =  MahasiswaDb.getMahasiswaDb(application);
        mahasiswaDao = db.mahasiswaDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void insert(Mahasiswa mahasiswa){
        executorService.execute(() -> mahasiswaDao.insert(mahasiswa));
    }

    public void update(Mahasiswa mahasiswa){
        executorService.execute(() -> mahasiswaDao.update(mahasiswa));
    }

    public void delete(Mahasiswa mahasiswa){
        executorService.execute(() -> mahasiswaDao.delete(mahasiswa));
    }

    public LiveData<List<Mahasiswa>> getAllMahasiswa(){
        return mahasiswaDao.showAllData();
    }

    public LiveData<List<Mahasiswa>> getDetail(int id){
        return mahasiswaDao.showDetail(id);
    }
}
