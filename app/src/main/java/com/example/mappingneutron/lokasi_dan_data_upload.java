package com.example.mappingneutron;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.droidnet.DroidListener;
import com.droidnet.DroidNet;
import com.example.mappingneutron.model.model;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class lokasi_dan_data_upload extends AppCompatActivity implements DroidListener {

    private final String TAG = "LOKASI_DAN_DATA_UPLOAD";

    private DroidNet mDroidNet;
    private static boolean networkStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DroidNet.init(this);
        setContentView(R.layout.activity_lokasi_dan_data_upload);
        Log.d("FUNIGGA", "FUIOIS");
        init();
    }

    private void init(){
        mDroidNet = DroidNet.getInstance();
        mDroidNet.addInternetConnectivityListener(this);
        TextView data1 = findViewById(R.id.tv_1);
        TextView data2 = findViewById(R.id.tv_2);
        TextView data3 = findViewById(R.id.tv_3);
        TextView data4 = findViewById(R.id.tv_4);
        TextView data5 = findViewById(R.id.tv_5);
        TextView data6 = findViewById(R.id.tv_6);
        TextView data7 = findViewById(R.id.tv_7);
        TextView data8 = findViewById(R.id.tv_8);
        TextView data9 = findViewById(R.id.tv_9);
        TextView data10 = findViewById(R.id.tv_10);
        TextView tindakan = findViewById(R.id.tv_tindakan);
        Button upload = findViewById(R.id.bt_upload);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);

        int ID = getIntent().getIntExtra("ID",0);

        model list_lokasi_dan_data_upload = new SQLiteHelper(lokasi_dan_data_upload.this).getDataLokasiDanData(Integer.toString((ID))).get(0);

        data1.setText(list_lokasi_dan_data_upload.getValues().get("DATA_01"));
        data2.setText(list_lokasi_dan_data_upload.getValues().get("DATA_02"));
        data3.setText(list_lokasi_dan_data_upload.getValues().get("DATA_03"));
        data4.setText(list_lokasi_dan_data_upload.getValues().get("DATA_04"));
        data5.setText(list_lokasi_dan_data_upload.getValues().get("DATA_05"));
        data6.setText(list_lokasi_dan_data_upload.getValues().get("DATA_06"));
        data7.setText(list_lokasi_dan_data_upload.getValues().get("DATA_07"));
        data8.setText(list_lokasi_dan_data_upload.getValues().get("DATA_08"));
        data9.setText(list_lokasi_dan_data_upload.getValues().get("DATA_09"));
        data10.setText(list_lokasi_dan_data_upload.getValues().get("DATA_10"));

        tindakan.setText(list_lokasi_dan_data_upload.getTindakan());

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        upload.setOnClickListener(v -> {
            if(networkStatus) {
                db.collection(list_lokasi_dan_data_upload.getPetugas())
                        .add(list_lokasi_dan_data_upload)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Snackbar.make(constraintLayout, getResources().getString(R.string.berhasil_unggah), Snackbar.LENGTH_SHORT).show();
                                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(constraintLayout, getResources().getString(R.string.gagal_unggah), Snackbar.LENGTH_SHORT).show();
                            }
                        });

            }

            else{
                Snackbar.make(constraintLayout, getResources().getString(R.string.koneksi_internet), Snackbar.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        DroidNet.getInstance().removeAllInternetConnectivityChangeListeners();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDroidNet.removeInternetConnectivityChangeListener(this);
    }

    @Override
    public void onInternetConnectivityChanged(boolean isConnected) {
        if (isConnected) {
            //do Stuff with internet
            networkStatus = true;
        } else {
            //no internet
            networkStatus = false;
        }
    }
}