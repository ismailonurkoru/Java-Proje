package Garanti;

import java.time.LocalDate;

public class UzatilmisGaranti extends Garanti {

    private double ucret;

    public UzatilmisGaranti(LocalDate baslangicTarihi, int ekSureAy, double ucret) {
        super(baslangicTarihi, 24 + ekSureAy);
        this.ucret = ucret;
    }

    @Override
    public String getGarantiTuru() {
        return "Uzatılmış Garanti";
    }

    @Override
    public double ucretHesapla() {
        return ucret;
    }

    public double getUcret() {
        return ucret;
    }
}

