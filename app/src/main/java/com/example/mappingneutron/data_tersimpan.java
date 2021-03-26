package com.example.mappingneutron;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mappingneutron.adapter.adapter_data_tersimpan;

public class data_tersimpan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.data_tersimpan);
        init();
    }

    void init(){
        // ImageView backButton = findViewById(R.id.back_button);
        // TextView tv_toolbar = findViewById(R.id.tv_toolbar);
        // tv_toolbar.setText(getString(R.string.applied_jobs));
        // backButton.setOnClickListener(view -> finish());
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);

        //appliedJobsAdapter apJobsAdapter = new appliedJobsAdapter(new SQLiteHelper(applied_jobs.this,currentFirebaseUser.getDisplayName().replaceAll("\\s",""), sharedPref.getInt(currentFirebaseUser.getEmail(),0)).getAppliedJobs(currentFirebaseUser.getDisplayName().replaceAll("\\s","")));

        adapter_data_tersimpan apJobsAdapter = new adapter_data_tersimpan(new SQLiteHelper(data_tersimpan.this).getData(), data_tersimpan.this);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(data_tersimpan.this));
        apJobsAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(apJobsAdapter);
    }
}