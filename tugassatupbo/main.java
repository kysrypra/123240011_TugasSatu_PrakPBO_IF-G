/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugassatupbo;

/**
 *
 * @author dikys
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    
    private static final int MAX_TIKET = 100;
    private static Tiket[] daftarTiket = new Tiket[MAX_TIKET];
    private static int jumlahTiket = 0;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== SISTEM TERMINAL LOKET OOP TIX ===");
        
        boolean lanjut = true;
        int nomorInput = 1;
        
        while (lanjut) {
            System.out.println("\n--- Input Tiket Ke-" + nomorInput + " ---");
            
            try {
                // Input data tiket
                System.out.print("Kode Booking (Awali 'TIX') : ");
                String kode = scanner.nextLine();
                
                System.out.print("Tanggal (DD/MM/YYYY) : ");
                String tanggal = scanner.nextLine();
                
                System.out.print("Waktu Keberangkatan : ");
                String waktu = scanner.nextLine();
                
                System.out.print("Stasiun Tujuan : ");
                String stasiun = scanner.nextLine();
                
                System.out.print("Harga Dasar (Rp) : ");
                double hargaDasar;
                try {
                    hargaDasar = Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    throw new InputMismatchException("Input harga harus berupa angka!");
                }
                
                System.out.print("Kelas (1=Eko, 2=Eks, 3=Lux) : ");
                int kelas;
                try {
                    kelas = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    throw new InputMismatchException("Input kelas harus berupa angka!");
                }
                
                // Buat objek jadwal
                Jadwal jadwal = new Jadwal(tanggal, waktu, stasiun);
                
                // Buat tiket sesuai kelas
                Tiket tiket = buatTiket(kode, jadwal, hargaDasar, kelas);
                
                // Simpan tiket
                if (jumlahTiket < MAX_TIKET) {
                    daftarTiket[jumlahTiket] = tiket;
                    jumlahTiket++;
                    System.out.println("[SUKSES] Tiket berhasil disimpan!");
                } else {
                    System.out.println("[GAGAL] Penyimpanan tiket penuh!");
                }
                
                nomorInput++;
                
            } catch (DataTicketInvalidException e) {
                System.out.println("[DITOLAK] " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("[ERROR SISTEM] " + e.getMessage());
            } catch (Exception e) {
                System.out.println("[ERROR SISTEM] Terjadi kesalahan: " + e.getMessage());
            }
            
            // Tanya apakah ingin input lagi
            System.out.print("Cetak tiket lain? (y/n): ");
            String jawab = scanner.nextLine();
            lanjut = jawab.equalsIgnoreCase("y");
        }
        
        // Tampilkan rekapitulasi
        tampilkanRekapitulasi();
        System.out.println("\nSesi loket diakhiri.");
        System.out.println("===================================");
        
        scanner.close();
    }
    
    private static Tiket buatTiket(String kode, Jadwal jadwal, double hargaDasar, int kelas) 
            throws DataTicketInvalidException {
        
        switch (kelas) {
            case 1:
                return new tiketEkonomi(kode, jadwal, hargaDasar);
            case 2:
                return new tiketEksekutif(kode, jadwal, hargaDasar);
            case 3:
                return new tiketLuxury(kode, jadwal, hargaDasar);
            default:
                throw new IllegalArgumentException("Kelas tidak valid! Pilih 1, 2, atau 3");
        }
    }
    
    private static void tampilkanRekapitulasi() {
        System.out.println("\n===================================");
        System.out.println("REKAPITULASI TIKET");
        System.out.println("===================================");
        
        if (jumlahTiket == 0) {
            System.out.println("Belum ada tiket yang diterbitkan.");
        } else {
            for (int i = 0; i < jumlahTiket; i++) {
                Tiket t = daftarTiket[i];
                System.out.println((i+1) + ". Kode: " + t.getKodeTiket() + 
                        " | Jadwal: " + t.getJadwal().getInfoJadwal() + 
                        " | Total Harga: Rp " + t.hitungHarga());
                
                // Tampilkan fasilitas jika tiket eksklusif
                if (t instanceof LayananEksklusif) {
                    System.out.println("   Fasilitas: " + ((LayananEksklusif) t).getFasilitasTambahan());
                }
            }
        }
        System.out.println("===================================");
    }
}