/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugassatupbo;

/**
 *
 * @author dikys
 */
public class tiketLuxury extends Tiket implements LayananEksklusif {
    
    public tiketLuxury(String kodeTiket, Jadwal jadwal, double hargaDasar) 
            throws DataTicketInvalidException {
        super(kodeTiket, jadwal, hargaDasar);
    }
    
    @Override
    public double hitungHarga() {
        return hargaDasar + 150000; // Tambahan Rp 150.000
    }
    
    @Override
    public String getFasilitasTambahan() {
        return "Makan Siang dan Kursi Sleeper";
    }
}
