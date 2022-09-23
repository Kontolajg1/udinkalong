/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.penjualan;

/**
 *
 * @author ASUS
 */
public class barangmodel {
    private String namabarang,kodebarang,gambar;
    private double tarif;
    
     public String getnamabarang() {
        return namabarang;    }
    
    public void setnamabarang(String namabarang) {        
        this.namabarang = namabarang;        }
     public String getkodebarang() {
        return kodebarang;    }
    
    public void setkodebarang(String kodebarang) {        
        this.kodebarang = kodebarang;        }
     public String getgambar() {
        return gambar;    }
    
    public void setgambar(String gambar) {        
        this.gambar = gambar;        }
     public double gettarif() {
        return tarif;    
     }
    
   
     public void settarif(double tarif) {        
        this.tarif = tarif;       
    }
    
    
}
