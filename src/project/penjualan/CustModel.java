package project.penjualan;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LIKMI
 */
public class CustModel {
    private String IdMember,nama, alamat,status;
    private double total;
    
    public String getIdMember() {
        return IdMember;    }
    
    public void setIdMember(String IdMember) {        
        this.IdMember = IdMember;        }
    
    public String getNama() {
        return nama;        }
    
    public void setNama(String nama) {        
        this.nama = nama;        }
    
    public String getAlamat() {
        return alamat;    
    }
    
    public void setAlamat(String alamat) {        
        this.alamat = alamat;    
    }
    
    public double getTotal() {        
        return total;    
    }
    
    public void setTotal(double total) {        
        this.total = total;    
    }
    public String getStatus() {
        return status;    
    }
    
    public void setStatus(String status) {        
        this.status = status;    
    }


    
    
}
