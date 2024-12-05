/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class PopupmenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Supplier(ActionEvent event) throws IOException {
           FXMLLoader loader= new FXMLLoader(getClass().getResource("SupplierDashbord.fxml"));
         Parent root=loader.load();
         Stage stage= new Stage();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    @FXML
    private void CleaningSupervisor(ActionEvent event) throws IOException {
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("CleaningSupervisor.fxml"));
         Parent root=loader.load();
         Stage stage= new Stage();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        
    }
    
}
