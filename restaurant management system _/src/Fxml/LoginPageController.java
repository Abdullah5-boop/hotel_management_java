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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class LoginPageController implements Initializable {

    @FXML
    private TextField LoginPasstxt;
    @FXML
    private TextField LoginIdtxt;
    @FXML
    private Label Registerlabeltxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleLogin(ActionEvent event) throws IOException {
        
      
      String id= LoginIdtxt.getText();
       String pass= LoginPasstxt.getText();
       Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Popupmenu.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Supplier DashBord");
        window.setScene(scene);
        window.show();
       
    }

    @FXML
    private void HandleRegisterlabel(MouseEvent event) {
              
        
    }
    
}
