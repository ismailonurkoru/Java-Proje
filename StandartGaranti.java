package Garanti;

import java.time.LocalDate;

public class StandartGaranti extends Garanti {

    public StandartGaranti(LocalDate baslangicTarihi) {
        super(baslangicTarihi, 24); // 24 ay
    }

    @Override
    public String getGarantiTuru() {
        return "Standart Garanti";
    }

    @Override
    public double ucretHesapla() {
        return 0.0; // ücretsiz
    }
}

