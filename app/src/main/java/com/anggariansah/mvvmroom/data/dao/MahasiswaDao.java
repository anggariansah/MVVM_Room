package com.anggariansah.mvvmroom.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.anggariansah.mvvmroom.data.model.Mahasiswa;

import java.util.List;

@Dao
public interface MahasiswaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Mahasiswa mahasiswa);

    @Update
    void update(Mahasiswa mahasiswa);

    @Delete
    void delete(Mahasiswa mahasiswa);

    @Query("SELECT * FROM MAHASISWA ORDER BY ID DESC")
    LiveData<List<Mahasiswa>> showAllData();

    @Query("SELECT * FROM MAHASISWA WHERE ID = :id")
    LiveData<List<Mahasiswa>> showDetail(int id);

}
