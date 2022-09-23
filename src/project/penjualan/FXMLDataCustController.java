/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
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
 * @author LIKMI
 */
public class FXMLDataCustController implements Initializable {

    @FXML
    private TableView<CustModel> tbvcust;
    @FXML
    private Button awaltombol;
    @FXML
    private Button sebelumtombol;
    @FXML
    private Button sesudahtombol;
    @FXML
    private Button akhirtombol;
    @FXML
    private Button tambahtombol;
    @FXML
    private Button hapustombol;
    @FXML
    private Button ubahtombol;
    @FXML
    private Button keluartombol;
    @FXML
    private TextField searchcust;
      

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showdata();
        
    }    
    
    public void showdata(){
        ObservableList<CustModel> data=FXMLDocumentController.dtcust.Load();
        if(data!=null){            
            tbvcust.getColumns().clear();            
            tbvcust.getItems().clear();
            TableColumn col=new TableColumn("IdMember");
            col.setCellValueFactory(new PropertyValueFactory<CustModel, String>("IdMember"));
            tbvcust.getColumns().addAll(col);
            col=new TableColumn("nama");
            col.setCellValueFactory(new PropertyValueFactory<CustModel, String>("nama"));
            tbvcust.getColumns().addAll(col);
            col=new TableColumn("alamat");
            col.setCellValueFactory(new PropertyValueFactory<CustModel, String>("alamat"));
            tbvcust.getColumns().addAll(col);
            col=new TableColumn("total");
            col.setCellValueFactory(new PropertyValueFactory<CustModel, String>("total"));
            col=new TableColumn("status");
            col.setCellValueFactory(new PropertyValueFactory<CustModel, String>("status"));
            tbvcust.getColumns().addAll(col);

          
            tbvcust.getColumns().addAll(col);
            tbvcust.setItems(data);
    }else {  Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvcust.getScene().getWindow().hide();;
        }                
    }

    @FXML
    private void awalpencet(ActionEvent event) {
        tbvcust.getSelectionModel().selectFirst();        
        tbvcust.requestFocus();    
    }

    @FXML
    private void sebelumpencet(ActionEvent event) {
       tbvcust.getSelectionModel().selectAboveCell();       
        tbvcust.requestFocus();    
   
    }

    @FXML
    private void sesudahpencet(ActionEvent event) {
        tbvcust.getSelectionModel().selectBelowCell();        
        tbvcust.requestFocus();

    }

    @FXML
    private void akhirpencet(ActionEvent event) {
        tbvcust.getSelectionModel().selectLast();        
        tbvcust.requestFocus();    

    }

    @FXML
    private void tambahpencet(ActionEvent event) {
                try{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputCustController.fxml"));    
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
    private void hapuspencet(ActionEvent event) {
                CustModel s= new CustModel();       
        s=tbvcust.getSelectionModel().getSelectedItem();
        Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Mau dihapus?",ButtonType.YES,ButtonType.NO);
        a.showAndWait();
        if(a.getResult()==ButtonType.YES){
           if(FXMLDocumentController.dtcust.delete(s.getIdMember())){
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
    private void ubahpencet(ActionEvent event) {
        CustModel s= new CustModel();
        s=tbvcust.getSelectionModel().getSelectedItem();
        try{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLInputCustController.fxml"));    
        Parent root = (Parent)loader.load();
        FXMLInputCustControllerController isidt=(FXMLInputCustControllerController)loader.getController();
        isidt.execute(s);                
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
    private void keluarpencet(ActionEvent event) {
        keluartombol.getScene().getWindow().hide();
    }

    @FXML
    private void mencaridata(KeyEvent event) {
        CustModel s = new CustModel();
        String key = searchcust.getText();
        if(key!=""){
        ObservableList<CustModel> data=FXMLDocumentController.dtcust.kontolcust(key,key);
        if(data!=null){            
            tbvcust.getColumns().clear();
            tbvcust.getItems().clear();
            TableColumn col=new TableColumn("IdMember");
            col.setCellValueFactory(new PropertyValueFactory<CustModel, String>("IdMember"));
            tbvcust.getColumns().addAll(col);
            col=new TableColumn("nama");
            col.setCellValueFactory(new PropertyValueFactory<CustModel, String>("nama"));
            tbvcust.getColumns().addAll(col);
 col=new TableColumn("alamat");
            col.setCellValueFactory(new PropertyValueFactory<CustModel, String>("alamat"));
            tbvcust.getColumns().addAll(col);
            col=new TableColumn("total ");
            col.setCellValueFactory(new PropertyValueFactory<CustModel, String>("total"));
            tbvcust.getColumns().addAll(col);       
            col=new TableColumn("status");
            col.setCellValueFactory(new PropertyValueFactory<CustModel, String>("status"));
            tbvcust.getColumns().addAll(col);
            tbvcust.setItems(data);
        }else {
            Alert a=new Alert(Alert.AlertType.ERROR,"Data kosong",ButtonType.OK);
            a.showAndWait();
            tbvcust.getScene().getWindow().hide();;
        }            
            } else{
               showdata();
            }        

    }
    
 

}
