package Servis;

import Cihazlar.Cihaz;
import Garanti.GarantiSuresiDolmusException;
import Garanti.Garanti;

import java.util.ArrayList;
import java.util.List;

public class CihazServisi {

    private List<Cihaz> cihazlar = new ArrayList<>();

    // Cihaz ekleme
    public void cihazEkle(Cihaz cihaz) {
        cihazlar.add(cihaz);
    }

    // Cihazları listeleme
    public void cihazlariListele() {
        if (cihazlar.isEmpty()) {
            System.out.println("Henüz kayıtlı cihaz yok.");
            return;
        }

        for (Cihaz c : cihazlar) {
            System.out.println(c);
        }
    }

    // Servis kaydı ekleme (iş kuralı burada!)
    public void servisKaydiEkle(String seriNo)
            throws GarantiSuresiDolmusException {

        Cihaz cihaz = cihazBul(seriNo);

        if (!cihaz.getGarantiSuresiAy().garantiDevamEdiyorMu()) {
            throw new GarantiSuresiDolmusException(
                    "Garanti süresi dolmuş cihaz servise alınamaz!"
            );
        }

        // Şimdilik sadece simülasyon
        System.out.println("Servis kaydı oluşturuldu: " + cihaz);
    }

    // Seri numarasına göre cihaz bulma
    private Cihaz cihazBul(String seriNo) {

        for (Cihaz c : cihazlar) {
            if (c.getSeriNo().equalsIgnoreCase(seriNo)) {
                return c;
            }
        }

        throw new IllegalArgumentException("Cihaz bulunamadı!");
    }

    // Getter & Setter
    public List<Cihaz> getCihazlar() {
        return cihazlar;
    }

    public void setCihazlar(List<Cihaz> cihazlar) {
        this.cihazlar = cihazlar;
    }
}
