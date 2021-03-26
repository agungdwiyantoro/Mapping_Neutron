package com.example.mappingneutron.model;

import java.util.HashMap;


public class model {
    private String tanggal;
    private String daya_operasi;
    private String alat_ukur;
    private String petugas;
    private HashMap<String, String> values;
    private String tindakan;

    public model() {
    }

    public model(String tanggal, String daya_operasi, String alat_ukur, String petugas, HashMap<String, String> values) {
        this.tanggal = tanggal;
        this.daya_operasi = daya_operasi;
        this.alat_ukur = alat_ukur;
        this.petugas = petugas;
        this.values = values;
    }

    public model(String tanggal, String daya_operasi, String alat_ukur, String petugas) {
        this.tanggal = tanggal;
        this.daya_operasi = daya_operasi;
        this.alat_ukur = alat_ukur;
        this.petugas = petugas;
    }

    public model(String tanggal, String daya_operasi, String alat_ukur, String petugas, HashMap<String, String> values, String tindakan) {
        this.tanggal = tanggal;
        this.daya_operasi = daya_operasi;
        this.alat_ukur = alat_ukur;
        this.petugas = petugas;
        this.values = values;
        this.tindakan = tindakan;
    }

    public model(HashMap<String, String> values, String tindakan) {
        this.values = values;
        this.tindakan = tindakan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getDaya_operasi() {
        return daya_operasi;
    }

    public String getAlat_ukur() {
        return alat_ukur;
    }

    public String getPetugas() {
        return petugas;
    }



    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setDaya_operasi(String daya_operasi) {
        this.daya_operasi = daya_operasi;
    }

    public void setAlat_ukur(String alat_ukur) {
        this.alat_ukur = alat_ukur;
    }

    public void setPetugas(String petugas) {
        this.petugas = petugas;
    }

    public HashMap<String, String> getValues() {
        return values;
    }

    public void setValues(HashMap<String, String> values) {
        this.values = values;
    }

    public String getTindakan() {
        return tindakan;
    }

    public void setTindakan(String tindakan) {
        this.tindakan = tindakan;
    }
}
