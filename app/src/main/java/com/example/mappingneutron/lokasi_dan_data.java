package com.example.mappingneutron;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mappingneutron.model.model;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.util.HashMap;

public class lokasi_dan_data extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lokasi_dan_data);
        init();
    }

    private void init(){

        Bundle b = getIntent().getExtras();

        SQLiteHelper sqLiteHelper = new SQLiteHelper(lokasi_dan_data.this);

        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);

        HashMap<String, String> data = new HashMap();

        EditText data1 = findViewById(R.id.et_1);
        EditText data2 = findViewById(R.id.et_2);
        EditText data3 = findViewById(R.id.et_3);
        EditText data4 = findViewById(R.id.et_4);
        EditText data5 = findViewById(R.id.et_5);
        EditText data6 = findViewById(R.id.et_6);
        EditText data7 = findViewById(R.id.et_7);
        EditText data8 = findViewById(R.id.et_8);
        EditText data9 = findViewById(R.id.et_9);
        EditText data10 = findViewById(R.id.et_10);

        EditText tindakan = findViewById(R.id.et_tindakan);

        Button simpan = findViewById(R.id.bt_simpan);

        simpan.setOnClickListener(v -> {
            data.put("DATA_01", data1.getText().toString());
            data.put("DATA_02", data2.getText().toString());
            data.put("DATA_03", data3.getText().toString());
            data.put("DATA_04", data4.getText().toString());
            data.put("DATA_05", data5.getText().toString());
            data.put("DATA_06", data6.getText().toString());
            data.put("DATA_07", data7.getText().toString());
            data.put("DATA_08", data8.getText().toString());
            data.put("DATA_09", data9.getText().toString());
            data.put("DATA_10", data10.getText().toString());

            if(data1.getText().toString().isEmpty() ||
                    data2.getText().toString().isEmpty() ||
                    data3.getText().toString().isEmpty() ||
                    data4.getText().toString().isEmpty() ||
                    data5.getText().toString().isEmpty() ||
                    data6.getText().toString().isEmpty() ||
                    data7.getText().toString().isEmpty() ||
                    data8.getText().toString().isEmpty() ||
                    data9.getText().toString().isEmpty() ||
                    data10.getText().toString().isEmpty() ||
                    tindakan.getText().toString().isEmpty()){

                Snackbar.make(constraintLayout, getResources().getString(R.string.lengkapi_data), Snackbar.LENGTH_SHORT).show();
            }
            else {

                sqLiteHelper.insertData(new model(b.getString(input_data.TANGGAL), b.getString(input_data.DAYA_OPERASI), b.getString(input_data.ALAT_UKUR), b.getString(input_data.PETUGAS),
                        data, tindakan.getText().toString()));
                Snackbar.make(constraintLayout, getResources().getString(R.string.berhasil_simpan), Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}