package com.anggariansah.mvvmroom.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.widget.Button;

import com.anggariansah.mvvmroom.R;
import com.anggariansah.mvvmroom.ui.viewmodel.AddMahasiswaViewModel;
import com.anggariansah.mvvmroom.utils.AddViewModelFactory;
import com.google.android.material.textfield.TextInputEditText;

public class AddMahasiswaActivity extends AppCompatActivity {

    private AddMahasiswaViewModel addMahasiswaViewModel;
    private Button btnTambah;
    private TextInputEditText edtNim, edtNama, edtKelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mahasiswa);

        edtNim = findViewById(R.id.edt_nim);
        edtNama = findViewById(R.id.edt_nama);
        edtKelas = findViewById(R.id.edt_kelas);
        btnTambah = findViewById(R.id.btn_tambah);

        if(getApplicationContext() != null){
            addMahasiswaViewModel = obtainViewModel(this.getApplication());
            saveMahasiswa();
        }

    }

    private void saveMahasiswa(){
        btnTambah.setOnClickListener(v -> {
            String nama = edtNama.getText().toString();
            String nim = edtNim.getText().toString();
            String kelas = edtKelas.getText().toString();

            addMahasiswaViewModel.insertMahasiswa(nim, nama, kelas);

            finish();
        });
    }


    @NonNull
    private AddMahasiswaViewModel obtainViewModel(Application application){
        AddViewModelFactory factory =  AddViewModelFactory.getInstance(application);
        return factory.create(AddMahasiswaViewModel.class);
    }
}
