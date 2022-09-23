/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.penjualan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class Dbbarang {
     private barangmodel dt=new barangmodel();    
    public barangmodel getbarangmodel(){ return(dt);}
    public void setbarangmodel(barangmodel s){ dt=s;}
    
    public ObservableList<barangmodel>  Load() {
        try {
            ObservableList<barangmodel> tableData=FXCollections.observableArrayList();
            Koneksi con = new Koneksi();            
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select kodebarang, namabarang, tarif from barang");
int i = 1;
            while (rs.next()) {
                barangmodel d=new barangmodel();
                d.setnamabarang (rs.getString("namabarang"));                
                d.setkodebarang(rs.getString("kodebarang"));
                d.settarif(rs.getDouble("tarif"));                
                //d.setgambar(rs.getString("gambar"));           
                tableData.add(d);                 
                i++;            
            }
            con.tutupKoneksi();            
            return tableData;
        } catch (Exception e) {            
            e.printStackTrace();            
            return null;        
        }
    }
    public int validasi(String kode) {
        int val = 0;
        try {         
            Koneksi con = new Koneksi();            
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(  "select count(*) as jml from barang where namabarang = '" + kode + "'");
            while (rs.next()) {                
                val = rs.getInt("jml");            
            }            
            con.tutupKoneksi();
        } catch (SQLException e) {            
            e.printStackTrace();        
        }
        return val;
    }
    public boolean insert() {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {       
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("insert into barang (namabarang,kodebarang, tarif, gambar) values (?,?,?,?)");
            con.preparedStatement.setString(1, getbarangmodel().getnamabarang());           
            con.preparedStatement.setString(2, getbarangmodel().getkodebarang());
            con.preparedStatement.setString(3, getbarangmodel().getgambar());           
            con.preparedStatement.setDouble(4, getbarangmodel().gettarif());    
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();            
            berhasil = false;
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }    
        
     }
    public boolean delete(String nomor) {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {            
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from barang where getnamabarang  = ? ");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();            
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        }
    }
         public boolean update() {
        boolean berhasil = false;        
        Koneksi con = new Koneksi();
        try {            
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement("update barang set namabarang = ?, tarif = ? where kodebarang = ? ");
            con.preparedStatement.setString(1, getbarangmodel().getnamabarang());           
            con.preparedStatement.setString(2, getbarangmodel().getkodebarang());
            con.preparedStatement.setString(3, getbarangmodel().getgambar());           
            con.preparedStatement.setDouble(4, getbarangmodel().gettarif());    
            con.preparedStatement.executeUpdate();     
            berhasil = true;
        } catch (Exception e) {            
            e.printStackTrace();            
            berhasil = false;
        } finally {            
            con.tutupKoneksi();            
            return berhasil;        
        } 
        }
        public ObservableList<barangmodel>  kontolcust(String kode, String nama) {
        try {    
            ObservableList<barangmodel> 	tableData;
            tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi(); 
            con.bukaKoneksi();
            con.statement = (Statement) con.dbKoneksi.createStatement();
            ResultSet rs = (ResultSet) con.statement.executeQuery("select kodebarang,nambarang,tarif from barang  WHERE kodebarang LIKE '" + kode + "%' OR namabarang LIKE '" + nama + "%'");
        int i = 1;
        while(rs.next()){
            barangmodel d = new barangmodel();
           d.setnamabarang (rs.getString("namabarang"));                
                d.setkodebarang(rs.getString("kodebarang"));
                d.settarif(rs.getDouble("tarif"));                
                d.setgambar(rs.getString("gambar"));           
                tableData.add(d);   
            //d.setStatus(rs.getString("status"));
            tableData.add(d);
            i++;
        }
        con.tutupKoneksi();
        return tableData;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}

