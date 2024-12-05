/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AddProductController implements Initializable {

    @FXML
    private TextField ProductNametxt;
    @FXML
    private TextField ProductPricetxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleAddProduct(ActionEvent event) {
    }

    @FXML
    private void HandleAddProductToDashbord(ActionEvent event) throws IOException {
          
       Parent root = FXMLLoader.load(getClass().getResource("SupplierDashbord.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Supplier DashBord");
        window.setScene(scene);
        window.show();
        
    }
    
}
