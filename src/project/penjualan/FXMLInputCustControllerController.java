/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.penjualan;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLInputCustControllerController implements Initializable {
 boolean editdata=false;
    @FXML
    private TextField textId;
    @FXML
    private TextField textNama;
    @FXML
    private TextField TextAlamat;
    @FXML
    private TextField TextTotal;
    @FXML
    private Button simpantombol;
    @FXML
    private Button bataltombol;
    @FXML
    private Button keluartombol;

    /**
     * Initializes the controller class.
     */
    public void execute(CustModel d){
        if(!d.getIdMember().isEmpty()){
          editdata=true;
          textId.setText(d.getIdMember());
          textNama.setText(d.getNama());          TextAlamat.setText(d.getAlamat());
          TextTotal.setText(String.valueOf(d.getTotal()));          
          textId.setEditable(false);          textNama.requestFocus();         
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

    @FXML
    
    private void simpanpencet(ActionEvent event) {
         CustModel n=new CustModel();        
        n.setIdMember(textId.getText());
        n.setNama(textNama.getText());     
        n.setAlamat(TextAlamat.getText());  
        n.setTotal(Double.parseDouble(TextTotal.getText()));
        FXMLDocumentController.dtcust.setCustModel(n);
        if(editdata){
            if(FXMLDocumentController.dtcust.update()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil diubah",ButtonType.OK);
               a.showAndWait();   
               textId.setEditable(true);        
               batalpencet(event);                
            } else {               
                Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal diubah",ButtonType.OK);
                a.showAndWait(); 
            }            }else if(FXMLDocumentController.dtcust.validasi(n.getIdMember())<=0){
            if(FXMLDocumentController.dtcust.insert()){
               Alert a=new Alert(Alert.AlertType.INFORMATION,"Data berhasil disimpan",ButtonType.OK);
               a.showAndWait();            
               batalpencet(event);
            } else {
               Alert a=new Alert(Alert.AlertType.ERROR,"Data gagal disimpan",ButtonType.OK);
               a.showAndWait();            
            }
        }else{Alert a=new Alert(Alert.AlertType.ERROR,"Data sudah ada",ButtonType.OK);
            a.showAndWait();
            textId.requestFocus();
        }
    }

    @FXML
    private void batalpencet(ActionEvent event) {
                textId.setText("");        
        textNama.setText("");
        TextAlamat.setText("");       
        TextTotal.setText("");  
        textId.requestFocus();
    
    }

    @FXML
    private void keluarpencet(ActionEvent event) {
        keluartombol.getScene().getWindow().hide();
    }
    
}

