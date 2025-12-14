package Cihazlar;

import java.time.LocalDate;

public class Tablet extends Cihaz {

    private double ekranBoyutu;
    private boolean kalemDestegi;

    public Tablet(String marka, String model, String seriNo,
                  LocalDate garantiBaslangic, int garantiSuresiAy,
                  double ekranBoyutu, boolean kalemDestegi) {

        super(marka, model, seriNo, garantiBaslangic, garantiSuresiAy);
        this.ekranBoyutu = ekranBoyutu;
        this.kalemDestegi = kalemDestegi;
    }

    @Override
    public String getCihazTuru() {
        return "Tablet";
    }

    @Override
    public double servisUcretiHesapla() {
        return kalemDestegi ? 600 : 500;
    }

    public double getEkranBoyutu() {
        return ekranBoyutu;
    }

    public boolean isKalemDestegi() {
        return kalemDestegi;
    }
}
