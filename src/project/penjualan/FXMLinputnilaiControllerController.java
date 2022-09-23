package project.penjualan;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLinputnilaiControllerController implements Initializable {

    @FXML
    private TextField barang;
    @FXML
    private TextField kode;
    @FXML
    private TextField tarif;
    @FXML
    private Button simpan;
    @FXML
    private Button batal;
    @FXML
    private Button keluar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void simpanpencet(ActionEvent event) {
    }

    @FXML
    private void batalpencet(ActionEvent event) {
    }

    @FXML
    private void keluarpencet(ActionEvent event) {
    }
    
}
