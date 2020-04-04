package com.anggariansah.mvvmroom.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.anggariansah.mvvmroom.data.dao.MahasiswaDao;
import com.anggariansah.mvvmroom.data.model.Mahasiswa;

@Database(entities = {Mahasiswa.class}, version = 1, exportSchema = false)
public abstract class MahasiswaDb extends RoomDatabase {

    public abstract MahasiswaDao mahasiswaDao();

    private static MahasiswaDb mahasiswaDb;

    public static MahasiswaDb getMahasiswaDb(Context context){
        if(mahasiswaDb == null){
            mahasiswaDb = Room.databaseBuilder(context.getApplicationContext(), MahasiswaDb.class, "mahasiswa_db")
                    .build();
        }
        return mahasiswaDb;
    }
}
