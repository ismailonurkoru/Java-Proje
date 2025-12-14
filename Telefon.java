package Cihazlar;

import java.time.LocalDate;

public class Telefon extends Cihaz {

    private boolean ciftSim;
    private int kameraMP;

    public Telefon(String marka, String model, String seriNo,
                   LocalDate garantiBaslangic, int garantiSuresiAy,
                   boolean ciftSim, int kameraMP) {

        super(marka, model, seriNo, garantiBaslangic, garantiSuresiAy);
        this.ciftSim = ciftSim;
        this.kameraMP = kameraMP;
    }

    @Override
    public String getCihazTuru() {
        return "Telefon";
    }

    @Override
    public double servisUcretiHesapla() {
        return 500 + (kameraMP * 2);
    }

    public boolean isCiftSim() {
        return ciftSim;
    }

    public int getKameraMP() {
        return kameraMP;
    }
}

