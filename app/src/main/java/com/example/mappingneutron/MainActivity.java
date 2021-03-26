package com.example.mappingneutron;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mappingneutron.model.model;
import com.example.mappingneutron.util.util;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = "MAIN_ACTIVITY";

    Button input_data, data_tersimpan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    private void init(){
        input_data = findViewById(R.id.bt_input_data);
        data_tersimpan = findViewById(R.id.bt_data_tersimpan);

        input_data.setOnClickListener(this);
        data_tersimpan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_input_data :
                toActivityClear(this, input_data.class);
                break;
            case R.id.bt_data_tersimpan :
                toActivityClear(this, data_tersimpan.class);
                break;
        }
    }


    public static void toActivityClear(Activity activity, Class toClass){
        Intent intent = new Intent(activity, toClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        activity.startActivity(intent);
    }
}

