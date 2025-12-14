package Cihazlar;

import Garanti.Garanti;
import Garanti.GarantiSuresiDolmusException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Cihaz {

    private String marka;
    private String model;
    private String seriNo;
    private LocalDate garantiBaslangic;
    private int garantiSuresiAy;// Ay cinsinden
    Garanti garanti;

    // Constructor
    public Cihaz(String marka, String model, String seriNo,
                 LocalDate garantiBaslangic, int garantiSuresiAy, Garanti garanti) {
        this.marka = marka;
        this.model = model;
        this.seriNo = seriNo;
        this.garantiBaslangic = garantiBaslangic;
        this.garantiSuresiAy = garantiSuresiAy;
        this.garanti = garanti;
    }


    // Abstract methods (PDF şartı)
    public abstract String getCihazTuru();
    public abstract double servisUcretiHesapla();

    // Concrete method
    public long garantiKalanGun() {
        LocalDate bitis = garantiBaslangic.plusMonths(garantiSuresiAy);
        return ChronoUnit.DAYS.between(LocalDate.now(), bitis);
    }

    public boolean garantiDevamEdiyorMu() {
        return garantiKalanGun() > 0;
    }

    // Getter & Setter
    public String getMarka(){
        return marka;
    }

    public void setMarka(String marka){
        this.marka = marka;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model = model;
    }

    public String getSeriNo(){
        return seriNo;
    }

    public void setSeriNo(String seriNo){
        this.seriNo = seriNo;
    }

    public LocalDate getGarantiBaslangic(){
        return garantiBaslangic;
    }

    public void setGarantiBaslangic(LocalDate garantiBaslangic){
        this.garantiBaslangic = garantiBaslangic;
    }

    public int getGarantiSuresiAy(){
        return garantiSuresiAy;
    }

    public void setGarantiSuresiAy(int garantiSuresiAy){
        if (garantiSuresiAy <= 0)
            throw new IllegalArgumentException("Garanti süresi 0 veya negatif olamaz!");
        this.garantiSuresiAy = garantiSuresiAy;
    }

    @Override
    public String toString() {
        return marka + " " + model + " (" + seriNo + ")";
    }

}
