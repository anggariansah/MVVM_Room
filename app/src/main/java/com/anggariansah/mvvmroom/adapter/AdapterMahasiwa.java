package com.anggariansah.mvvmroom.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anggariansah.mvvmroom.R;
import com.anggariansah.mvvmroom.data.model.Mahasiswa;

import java.util.List;

public class AdapterMahasiwa extends RecyclerView.Adapter<AdapterMahasiwa.Holder> {

    private List<Mahasiswa> mahasiswas;
    private OnItemClickListener onItemClickListener;

    public AdapterMahasiwa(List<Mahasiswa> mahasiswas,  OnItemClickListener onItemClickListener) {
        this.mahasiswas = mahasiswas;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Mahasiswa post = mahasiswas.get(position);
        holder.tvNim.setText(post.getNim());
        holder.tvNama.setText(post.getNama());
        holder.tvKelas.setText(post.getKelas());

        holder.container.setOnClickListener(v -> {
            onItemClickListener.onItemClick(v, position);
        });
    }

    @Override
    public int getItemCount() {
        return mahasiswas.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        TextView tvNim, tvNama, tvKelas;
        View container;

        Holder(@NonNull View itemView) {
            super(itemView);

            container = itemView;

            tvNim = itemView.findViewById(R.id.tv_nim);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvKelas = itemView.findViewById(R.id.tv_kelas);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }
}
