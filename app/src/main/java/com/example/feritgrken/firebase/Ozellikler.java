package com.example.feritgrken.firebase;

public class Ozellikler {
    String Id;
    int Yas;
    int Kilo;
    String Okul;

    public Ozellikler() {
    }

    public Ozellikler(String id, int yas, int kilo, String okul) {
        Id = id;
        Yas = yas;
        Kilo = kilo;
        Okul = okul;
    }

    public String getId() {
        return Id;
    }

    public int getYas() {
        return Yas;
    }

    public int getKilo() {
        return Kilo;
    }

    public String getOkul() {
        return Okul;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setYas(int yas) {
        Yas = yas;
    }

    public void setKilo(int kilo) {
        Kilo = kilo;
    }

    public void setOkul(String okul) {
        Okul = okul;
    }
}
