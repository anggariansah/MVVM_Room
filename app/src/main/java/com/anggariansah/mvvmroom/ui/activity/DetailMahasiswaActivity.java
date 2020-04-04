package com.anggariansah.mvvmroom.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.anggariansah.mvvmroom.R;
import com.anggariansah.mvvmroom.data.model.Mahasiswa;
import com.anggariansah.mvvmroom.ui.viewmodel.DetailMahasiswaViewModel;
import com.anggariansah.mvvmroom.utils.DetailViewModelFactory;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class DetailMahasiswaActivity extends AppCompatActivity {

    int id;
    private DetailMahasiswaViewModel detailMahasiswaViewModel;
    private TextInputEditText edtNim, edtNama, edtKelas;
    Button btnUpdate, btnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        id = getIntent().getIntExtra("id", 2);

        edtNim = findViewById(R.id.edt_nim);
        edtNama = findViewById(R.id.edt_nama);
        edtKelas = findViewById(R.id.edt_kelas);
        btnUpdate = findViewById(R.id.btn_update);
        btnDelete = findViewById(R.id.btn_delete);

        if(getApplicationContext() != null){
            detailMahasiswaViewModel = obtainViewModel(this.getApplication());
            observerViewModel(id);
        }

        btnUpdate.setOnClickListener(v -> {
            String nim = edtNim.getText().toString();
            String nama = edtNama.getText().toString();
            String kelas = edtKelas.getText().toString();

            detailMahasiswaViewModel.updateMahasiswa(id, nim, nama, kelas);

            finish();
        });

        btnDelete.setOnClickListener(v -> {
            detailMahasiswaViewModel.deleteMahasiswa(id);

            Intent intent = new Intent(DetailMahasiswaActivity.this, MainActivity.class);
            startActivity(intent);

        });
    }

    private void observerViewModel(int id) {
        detailMahasiswaViewModel.getDetailMahasiswa(id).observe(this, this::setMahasiwaToView);
    }

    private void setMahasiwaToView(List<Mahasiswa> listMahasiswa){
        Mahasiswa mahasiswa = listMahasiswa.get(0);
        edtNim.setText(mahasiswa.getNim());
        edtNama.setText(mahasiswa.getNama());
        edtKelas.setText(mahasiswa.getKelas());
    }


    @NonNull
    private DetailMahasiswaViewModel obtainViewModel(Application application){
        DetailViewModelFactory factory =  DetailViewModelFactory.getInstance(application);
        return factory.create(DetailMahasiswaViewModel.class);
    }
}
