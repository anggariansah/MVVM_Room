package com.anggariansah.mvvmroom.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import com.anggariansah.mvvmroom.R;
import com.anggariansah.mvvmroom.adapter.AdapterMahasiwa;
import com.anggariansah.mvvmroom.data.model.Mahasiswa;
import com.anggariansah.mvvmroom.ui.viewmodel.MahasiswaViewModel;
import com.anggariansah.mvvmroom.utils.ViewModelFactory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMahasiswa;
    private MahasiswaViewModel mahasiswaViewModel;
    FloatingActionButton fabPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMahasiswa = findViewById(R.id.rv_mahasiswa);
        fabPlus = findViewById(R.id.fab_plus);

        fabPlus.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddMahasiswaActivity.class);
            startActivity(intent);
        });

        if(getApplicationContext() != null){
            mahasiswaViewModel = obtainViewModel(this.getApplication());
            observerViewModel();
        }


    }

    private void observerViewModel() {
        mahasiswaViewModel.getAllMahasiswa().observe(this, this::setMahasiwaToView);
    }


    private void setMahasiwaToView(List<Mahasiswa> listMahasiswa){
        rvMahasiswa.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvMahasiswa.setAdapter(new AdapterMahasiwa(listMahasiswa, (v, position) -> {
              int id = listMahasiswa.get(position).getId();

              Intent intent = new Intent(MainActivity.this, DetailMahasiswaActivity.class);
              intent.putExtra("id",id);
              startActivity(intent);
        }));
    }

    @NonNull
    private MahasiswaViewModel obtainViewModel(Application application){
        ViewModelFactory factory =  ViewModelFactory.getInstance(application);
        return factory.create(MahasiswaViewModel.class);
    }
}
