package Cihazlar;

import java.time.LocalDate;

public class Laptop extends Cihaz {

    private int ramGB;
    private boolean ssd;

    public Laptop(String marka, String model, String seriNo,
                  LocalDate garantiBaslangic, int garantiSuresiAy,
                  int ramGB, boolean ssd) {

        super(marka, model, seriNo, garantiBaslangic, garantiSuresiAy);
        this.ramGB = ramGB;
        this.ssd = ssd;
    }

    @Override
    public String getCihazTuru() {
        return "Laptop";
    }

    @Override
    public double servisUcretiHesapla() {
        double ucret = 800 + (ramGB * 10);
        if (ssd) ucret += 200;
        return ucret;
    }

    public int getRamGB() {
        return ramGB;
    }

    public boolean isSsd() {
        return ssd;
    }
}
