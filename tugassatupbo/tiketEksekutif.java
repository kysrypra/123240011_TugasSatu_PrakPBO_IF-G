/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugassatupbo;

/**
 *
 * @author dikys
 */
public class tiketEksekutif extends Tiket implements LayananEksklusif {
    
    public tiketEksekutif(String kodeTiket, Jadwal jadwal, double hargaDasar) 
            throws DataTicketInvalidException {
        super(kodeTiket, jadwal, hargaDasar);
    }
    
    @Override
    public double hitungHarga() {
        return hargaDasar + 50000; // Tambahan Rp 50.000
    }
    
    @Override
    public String getFasilitasTambahan() {
        return "Makan Siang";
    }
}