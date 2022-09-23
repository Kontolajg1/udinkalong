/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.penjualan;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */

public class FXMLDataBarangController implements Initializable {

    @FXML
    private TextField searchbarang;
    @FXML
    private Button keluartombol;
    @FXML
    private Button ubahtombol;
    @FXML
    private Button hapustombol;
    @FXML
    private Button tambahtombol;
    @FXML
    private Button akhirtombol;
    @FXML
    private Button sesudahtombol;
    @FXML
    private Button sebelumtombol;
    @FXML
    private Button awaltombol;

    @FXML
    private TableView<barangmodel> tbvbarang;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       showdata();
    }
        public void showdata(){
        ObservableList<barangmodel> data=FXMLDocumentController.dtbarang.Load();
        if(data!=null){            
            tbvbarang.getColumns().clear();       
            tbvbarang.getItems().clear();
            TableColumn col=new TableColumn("namabarang");
            col.setCellValueFactory(new PropertyValueFactory<barangmodel, String>("namabarang"));
            tbvbarang.getColumns().addAll(col);
            col=new TableColumn("kodebarang");
            col.setCellValueFactory(new PropertyValueFactory<barangmodel, String>("kodebarang"));
            tbvbarang.getColumns().addAll(col);
            col=new TableColumn("tarif");
            col.setCellValueFactory(new PropertyValueFactory<barangmodel, Double>("tarif"));
            tbvbarang.getColumns().addAll(col);
            //col=new TableColumn("gambar");
            //col.setCellValueFactory(new PropertyValueFactory<barangmodel, String>("gambar"));
            //tbvbarang.getColumns().addAll(col);
            tbvbarang.setItems(data);
    }else {  Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvbarang.getScene().getWindow().hide();;
        }            
    }   

    @FXML
    private void mencaridata(KeyEvent event) {
        
        
    }

    @FXML
    private void keluarpencet(ActionEvent event) {
        keluartombol.getScene().getWindow().hide();
    }

    @FXML
    private void ubahpencet(ActionEvent event) {
        barangmodel s= new barangmodel();
        s=tbvbarang.getSelectionModel().getSelectedItem();
        try{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputbarang.fxml"));    
        Parent root = (Parent)loader.load();
        //FXMLInputCustControllerController isidt=(FXMLInputCustControllerController)loader.getController();
       // isidt.execute(s);                
        Scene scene = new Scene(root);
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);
        stg.setIconified(false);
        stg.setScene(scene);
        stg.showAndWait();
        } catch (IOException e){   e.printStackTrace();   }
        showdata();  
        awalpencet(event);
    }

    @FXML
    private void hapuspencet(ActionEvent event) {
       barangmodel s= new barangmodel();       
        s=tbvbarang.getSelectionModel().getSelectedItem();
        Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Mau dihapus?",ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
           if(FXMLDocumentController.dtbarang.delete(s.getkodebarang())){
               Alert b=new Alert(Alert.AlertType.INFORMATION,"Data berhasil dihapus", ButtonType.OK);
               b.showAndWait();
           } else {
               Alert b=new Alert(Alert.AlertType.ERROR,"Data gagal dihapus", ButtonType.OK);
               b.showAndWait();               
           }    
           showdata();           
           awalpencet(event);       
        }       

    }

    @FXML
    private void tambahpencet(ActionEvent event) {
         try{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputbarang.fxml"));    
        Parent root = (Parent)loader.load();        
        Scene scene = new Scene(root);        
        Stage stg=new Stage();
        stg.initModality(Modality.APPLICATION_MODAL);
        stg.setResizable(false);        
        stg.setIconified(false);        
        stg.setScene(scene);
        stg.showAndWait();
        } catch (IOException e){   
            e.printStackTrace();   }
        showdata();        
        awalpencet(event);

    }

    @FXML
    private void akhirpencet(ActionEvent event) {
        tbvbarang.getSelectionModel().selectLast();        
        tbvbarang.requestFocus();    
    }

    @FXML
    private void sesudahpencet(ActionEvent event) {
    tbvbarang.getSelectionModel().selectBelowCell();        
        tbvbarang.requestFocus();  
    }

    @FXML
    private void sebelumpencet(ActionEvent event) {
         tbvbarang.getSelectionModel().selectAboveCell();       
        tbvbarang.requestFocus();    
    }

    @FXML
    private void awalpencet(ActionEvent event) {
         tbvbarang.getSelectionModel().selectFirst();        
        tbvbarang.requestFocus();    
    }
    
}
