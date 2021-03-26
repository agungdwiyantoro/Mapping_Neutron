package com.example.mappingneutron;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.mappingneutron.model.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DATABASE_SAVED_DATA";

    private final String TABLE_NAME = "TABLE_SAVED_DATA";

    private final String ID = "ID";
    private final String TANGGAL = "TANGGAL";
    private final String DATA_OPERASI = "DAYA_OPERASI";
    private final String ALAT_UKUR = "ALAT_UKUR";
    private final String PETUGAS = "PETUGAS";

    public final String DATA_01 = "DATA_01";
    public final String DATA_02 = "DATA_02";
    public final String DATA_03 = "DATA_03";
    public final String DATA_04 = "DATA_04";
    public final String DATA_05 = "DATA_05";
    public final String DATA_06 = "DATA_06";
    public final String DATA_07 = "DATA_07";
    public final String DATA_08 = "DATA_08";
    public final String DATA_09 = "DATA_09";
    public final String DATA_10 = "DATA_10";

    private final String TINDAKAN = "TINDAKAN";

    private final String TAG = "SQLiteHelper";


    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");
        db.execSQL(CREATE_TABLE());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Log.d(TAG, "onUpgrade" + DATABASE_VERSION);
        //   db.execSQL("CREATE TABLE IF NOT EXISTS  " + TABLE_NAME );
        // DATABASE_VERSION++;
        //  DATABASE_VERSION++;
        //  Log.d(TAG, "db " + DATABASE_VERSION);
        //db.execSQL(CREATE_TABLE(TABLE_NAME));
        onCreate(db);
    }


    private String CREATE_TABLE() {
        return "CREATE TABLE IF NOT EXISTS  " + TABLE_NAME + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                TANGGAL + " VARCHAR(50)," +
                DATA_OPERASI + " VARCHAR(20)," +
                ALAT_UKUR + " VARCHAR(20)," +
                PETUGAS + " VARCHAR(50)," +

                DATA_01 + " VARCHAR(20)," +
                DATA_02 + " VARCHAR(20)," +
                DATA_03 + " VARCHAR(20)," +
                DATA_04 + " VARCHAR(20)," +
                DATA_05 + " VARCHAR(20)," +
                DATA_06 + " VARCHAR(20)," +
                DATA_07 + " VARCHAR(20)," +
                DATA_08 + " VARCHAR(20)," +
                DATA_09 + " VARCHAR(20)," +
                DATA_10 + " VARCHAR(20)," +

                TINDAKAN + " VARCHAR(20)" +

                ");";
    }

    public void insertData(model data){
        SQLiteDatabase db  = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TANGGAL, data.getTanggal());
        values.put(DATA_OPERASI, data.getDaya_operasi());
        values.put(ALAT_UKUR, data.getAlat_ukur());
        values.put(PETUGAS, data.getPetugas());

        for(int i =1; i < data.getValues().size(); i++){
            Log.d("fuck nigga", data.getValues().get("DATA_0"+i));
            values.put("DATA_0"+i, data.getValues().get("DATA_0"+i));
        }
        values.put("DATA_10", data.getValues().get("DATA_10"));

        values.put(TINDAKAN, data.getTindakan());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<model> getData() {
        Log.d(TAG, "listData");
        List<model> listData = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME + " ORDER BY " + ID + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                model data = new model();
                data.setTanggal(cursor.getString(cursor.getColumnIndex(TANGGAL)));
                data.setDaya_operasi(cursor.getString(cursor.getColumnIndex(DATA_OPERASI)));
                data.setAlat_ukur((cursor.getString(cursor.getColumnIndex(ALAT_UKUR))));
                data.setPetugas((cursor.getString(cursor.getColumnIndex(PETUGAS))));
                listData.add(data);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return listData;
    }


    public List<model> getDataLokasiDanData(String id) {
        Log.d(TAG, "listData");
        List<model> listData = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + TABLE_NAME + " WHERE " + ID + "='" + id + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        HashMap<String, String> data_map = new HashMap<>();
        if (cursor.moveToFirst()) {
            do {
                model data = new model();

                data.setTanggal(cursor.getString(cursor.getColumnIndex(TANGGAL)));
                data.setDaya_operasi(cursor.getString(cursor.getColumnIndex(DATA_OPERASI)));
                data.setAlat_ukur((cursor.getString(cursor.getColumnIndex(ALAT_UKUR))));
                data.setPetugas((cursor.getString(cursor.getColumnIndex(PETUGAS))));
                data_map.put(DATA_01,cursor.getString(cursor.getColumnIndex(DATA_01)));
                data_map.put(DATA_02,cursor.getString(cursor.getColumnIndex(DATA_02)));
                data_map.put(DATA_03,cursor.getString(cursor.getColumnIndex(DATA_03)));
                data_map.put(DATA_04,cursor.getString(cursor.getColumnIndex(DATA_04)));
                data_map.put(DATA_05,cursor.getString(cursor.getColumnIndex(DATA_05)));
                data_map.put(DATA_06,cursor.getString(cursor.getColumnIndex(DATA_06)));
                data_map.put(DATA_07,cursor.getString(cursor.getColumnIndex(DATA_07)));
                data_map.put(DATA_08,cursor.getString(cursor.getColumnIndex(DATA_08)));
                data_map.put(DATA_09,cursor.getString(cursor.getColumnIndex(DATA_09)));
                data_map.put(DATA_10,cursor.getString(cursor.getColumnIndex(DATA_10)));

                data.setValues(data_map);
                data.setTindakan(cursor.getString(cursor.getColumnIndex(TINDAKAN)));

                listData.add(data);
            } while (cursor.moveToNext());
        }


        cursor.close();
        db.close();

        return listData;
    }
}