package com.example.mappingneutron;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.mappingneutron.model.model;
import com.example.mappingneutron.util.util;
import com.google.android.material.snackbar.Snackbar;

public class input_data extends AppCompatActivity {

    private final String TAG = "MAIN_ACTIVITY";

    public static final String TANGGAL = "TANGGAL";
    public static final String DAYA_OPERASI = "DAYA_OPERASI";
    public static final String ALAT_UKUR = "ALAT_UKUR";
    public static final String PETUGAS = "PETUGAS";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_data);
        init();
    }


    private void init(){
        TextView tanggal = findViewById(R.id.tv_tanggal);
        EditText daya_operasi = findViewById(R.id.et_daya_operasi);
        EditText alat_ukur = findViewById(R.id.et_alat_ukur);
        EditText petugas = findViewById(R.id.et_petugas);

        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);

        String convertedDate = util.convertDate(util.getCurrentDate());

        tanggal.setText(convertedDate);

        Button next = findViewById(R.id.bt_next);
        next.setOnClickListener(v -> {
            if(daya_operasi.getText().toString().isEmpty() || alat_ukur.getText().toString().isEmpty() || petugas.getText().toString().isEmpty()){
                Snackbar.make(constraintLayout, getResources().getString(R.string.lengkapi_data), Snackbar.LENGTH_SHORT).show();
            }
            else{
                sentBundle(convertedDate, daya_operasi.getText().toString(), alat_ukur.getText().toString(), petugas.getText().toString());
            }

        });
    }

    private void sentBundle(String tanggal, String daya_operasi, String alat_ukur, String petugas){
        Bundle b = new Bundle();
        b.putString(TANGGAL, tanggal);
        b.putString(DAYA_OPERASI, daya_operasi);
        b.putString(ALAT_UKUR, alat_ukur);
        b.putString(PETUGAS, petugas);
        Intent toLokasiDanData = new Intent(input_data.this, lokasi_dan_data.class);
        toLokasiDanData.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        toLokasiDanData.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        toLokasiDanData.putExtras(b);
        startActivity(toLokasiDanData);
    }
}
