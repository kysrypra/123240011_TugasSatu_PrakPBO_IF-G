/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tugassatupbo;

/**
 *
 * @author dikys
 */
public class tiketEkonomi extends Tiket {
    
    public tiketEkonomi(String kodeTiket, Jadwal jadwal, double hargaDasar) 
            throws DataTicketInvalidException {
        super(kodeTiket, jadwal, hargaDasar);
    }
    
    @Override
    public double hitungHarga() {
        return hargaDasar; // Harga sama dengan harga dasar
    }
}