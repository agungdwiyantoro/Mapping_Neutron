package com.example.mappingneutron.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mappingneutron.MainActivity;
import com.example.mappingneutron.R;
import com.example.mappingneutron.lokasi_dan_data_upload;
import com.example.mappingneutron.model.model;

import java.util.Date;
import java.util.List;



public class adapter_data_tersimpan extends RecyclerView.Adapter<adapter_data_tersimpan.MyViewHolder> {

    private List<model> dataList;
    private Context context;


    public adapter_data_tersimpan(List<model> dataList, Context context){
        this.dataList = dataList;
        this.context = context;
    }


    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tanggal, alat_ukur, petugas, daya_operasi;
        MyViewHolder(View itemView){
            super(itemView);
            tanggal = itemView.findViewById(R.id.tv_tanggal);
            alat_ukur = itemView.findViewById(R.id.tv_alat_ukur);
            petugas = itemView.findViewById(R.id.tv_petugas);
            daya_operasi = itemView.findViewById(R.id.tv_daya_operasi);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_data_tersimpan, viewGroup, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
        model data = dataList.get(i);
        myViewHolder.tanggal.setText(data.getTanggal());
        myViewHolder.daya_operasi.setText(data.getDaya_operasi());
        myViewHolder.alat_ukur.setText(data.getAlat_ukur());
        myViewHolder.petugas.setText(data.getPetugas());

        myViewHolder.itemView.setOnClickListener(view -> {
            toLokasiDanDataUpload(context, dataList.size()-i);
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private void toLokasiDanDataUpload(Context context, int id){
        Intent lokadiDanDataUpload = new Intent(context, lokasi_dan_data_upload.class);
        lokadiDanDataUpload.putExtra("ID", id);
        context.startActivity(lokadiDanDataUpload);
    }

}
