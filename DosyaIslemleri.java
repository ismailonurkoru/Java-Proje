package Servis;

import Cihazlar.*;
import Garanti.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DosyaIslemleri {

    private static final String DOSYA_ADI = "cihazlar.txt";

    // Dosyaya yazma
    public static void cihaziYaz(List<Cihaz> cihazlar) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(DOSYA_ADI))) {

            for (Cihaz c : cihazlar) {

                writer.write(
                        c.getCihazTuru() + "," +
                                c.getMarka() + "," +
                                c.getModel() + "," +
                                c.getSeriNo() + "," +
                                c.getGarantiSuresiAy() + "," +
                                c.getGarantiSuresiAy()
                );
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Dosyaya yazma hatası!");
        }
    }

    // Dosyadan okuma
    public static List<Cihaz> cihaziOku() {

        List<Cihaz> liste = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(DOSYA_ADI))) {

            String satir;

            while ((satir = reader.readLine()) != null) {

                String[] p = satir.split(",");

                String tur = p[0];
                String marka = p[1];
                String model = p[2];
                String seri = p[3];
                LocalDate tarih = LocalDate.parse(p[4]);
                int sure = Integer.parseInt(p[5]);

                Garanti garanti = new StandartGaranti(tarih);

                Cihaz cihaz = null;

                switch (tur) {
                    case "Telefon":
                        cihaz = new Telefon(marka, model, seri, garanti, true, 48);
                        break;
                    case "Laptop":
                        cihaz = new Laptop(marka, model, seri, garanti, 16, true);
                        break;
                    case "Tablet":
                        cihaz = new Tablet(marka, model, seri, garanti, 10.1, false);
                        break;
                }

                if (cihaz != null) {
                    liste.add(cihaz);
                }
            }

        } catch (IOException e) {
            System.out.println("Dosyadan okuma hatası!");
        }

        return liste;
    }
}
{
}
