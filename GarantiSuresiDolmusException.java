package Garanti;
import Cihazlar.Cihaz;

public class GarantiSuresiDolmusException extends Exception{
    public GarantiSuresiDolmusException(String mesaj) {
        super(mesaj);
    }

    public void servisEkle(Cihaz cihaz) throws GarantiSuresiDolmusException {

        if (!cihaz.garantiDevamEdiyorMu()) {
            throw new GarantiSuresiDolmusException(
                    "Bu cihazın garanti süresi dolmuştur!");
        }

        // Servis ekleme işlemleri
    }

}
