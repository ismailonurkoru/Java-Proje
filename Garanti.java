package Garanti;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Garanti {

    protected LocalDate baslangicTarihi;
    protected int sureAy; // Ay cinsinden

    // Constructor
    public Garanti(LocalDate baslangicTarihi, int sureAy) {
        this.baslangicTarihi = baslangicTarihi;
        this.sureAy = sureAy;
    }

    // Abstract methodlar (PDF şartı)
    public abstract String getGarantiTuru();
    public abstract double ucretHesapla();

    // Concrete method
    public LocalDate bitisTarihi() {
        return baslangicTarihi.plusMonths(sureAy);
    }

    public long kalanGun() {
        return ChronoUnit.DAYS.between(LocalDate.now(), bitisTarihi());
    }

    public boolean garantiDevamEdiyorMu() {
        return kalanGun() > 0;
    }

    // Getter & Setter
    public LocalDate getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public int getSureAy() {
        return sureAy;
    }

    public void setSureAy(int sureAy) {
        if (sureAy <= 0)
            throw new IllegalArgumentException("Garanti süresi 0 veya negatif olamaz!");
        this.sureAy = sureAy;
    }
}
