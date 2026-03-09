/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugassatupbo;

/**
 *
 * @author dikys
 */
public abstract class Tiket {
    protected String kodeTiket;
    protected Jadwal jadwal;
    protected double hargaDasar;
    
    public Tiket(String kodeTiket, Jadwal jadwal, double hargaDasar) 
            throws DataTicketInvalidException {
        
        // Validasi Aturan 5
        if (!kodeTiket.startsWith("TIX")) {
            throw new DataTicketInvalidException("Kode booking wajib diawali 'TIX'");
        }
        
        if (hargaDasar <= 0) {
            throw new DataTicketInvalidException("Harga dasar harus > 0");
        }
        
        this.kodeTiket = kodeTiket;
        this.jadwal = jadwal;
        this.hargaDasar = hargaDasar;
    }
    
    // Method abstract yang harus diimplementasi subclass
    public abstract double hitungHarga();
    
    // Getter methods
    public String getKodeTiket() {
        return kodeTiket;
    }
    
    public Jadwal getJadwal() {
        return jadwal;
    }
}