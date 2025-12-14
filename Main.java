import Cihazlar.*;
import Garanti.*;
import service.CihazServisi;
import service.DosyaIslemleri;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            CihazServisi cihazServisi = new CihazServisi();

            boolean devam = true;

            while (devam) {
                System.out.println("\n--- DİJİTAL CİHAZ GARANTİ & SERVİS TAKİP ---");
                System.out.println("1- Cihaz Ekle");
                System.out.println("2- Cihazları Listele");
                System.out.println("3- Servis Kaydı Ekle");
                System.out.println("4- Dosyaya Kaydet");
                System.out.println("5- Dosyadan Oku");
                System.out.println("0- Çıkış");
                System.out.print("Seçim: ");

                int secim = scanner.nextInt();
                scanner.nextLine(); // buffer temizle

                try {
                    switch (secim) {

                        case 1:
                            cihazEkle(scanner, cihazServisi);
                            break;

                        case 2:
                            cihazServisi.cihazlariListele();
                            break;

                        case 3:
                            servisEkle(scanner, cihazServisi);
                            break;

                        case 4:
                            DosyaIslemleri.cihaziYaz(cihazServisi.getCihazlar());
                            System.out.println("Dosyaya kaydedildi.");
                            break;

                        case 5:
                            List<Cihaz> okunanlar = DosyaIslemleri.cihaziOku();
                            cihazServisi.setCihazlar(okunanlar);
                            System.out.println("Dosyadan okundu.");
                            break;

                        case 0:
                            devam = false;
                            System.out.println("Çıkış yapılıyor...");
                            break;

                        default:
                            System.out.println("Geçersiz seçim!");
                    }

                } catch (GarantiSuresiDolmusException e) {
                    System.out.println("HATA: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Beklenmeyen hata: " + e.getMessage());
                }
            }
            scanner.close();
        }

        // ------------------ YARDIMCI METOTLAR ------------------

        private static void cihazEkle(Scanner scanner, CihazServisi servis) {

            System.out.print("Cihaz Türü (1-Telefon 2-Laptop 3-Tablet): ");
            int tur = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Marka: ");
            String marka = scanner.nextLine();

            System.out.print("Model: ");
            String model = scanner.nextLine();

            System.out.print("Seri No: ");
            String seri = scanner.nextLine();

            Garanti garanti = new StandartGaranti(LocalDate.now());

            Cihaz cihaz = null;

            switch (tur) {
                case 1:
                    cihaz = new Telefon(marka, model, seri, garanti, true, 48);
                    break;
                case 2:
                    cihaz = new Laptop(marka, model, seri, garanti, 16, true);
                    break;
                case 3:
                    cihaz = new Tablet(marka, model, seri, garanti, 10.1, false);
                    break;
                default:
                    System.out.println("Geçersiz cihaz türü!");
                    return;
            }

            servis.cihazEkle(cihaz);
            System.out.println("Cihaz eklendi.");
        }

        private static void servisEkle(Scanner scanner, CihazServisi servis)
                throws GarantiSuresiDolmusException {

            System.out.print("Seri No girin: ");
            String seriNo = scanner.nextLine();

            servis.servisKaydiEkle(seriNo);
            System.out.println("Servis kaydı oluşturuldu.");
        }
    }

}
