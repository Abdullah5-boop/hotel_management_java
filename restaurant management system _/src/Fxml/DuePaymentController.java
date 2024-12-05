/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import Fxml.AbdullahClass.Supplier;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class DuePaymentController implements Initializable {

    @FXML
    private Label Notification;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadData();
        // TODO
     
        
    }    

    @FXML
    private void Backtodashbord(ActionEvent event) throws IOException {
        String path = "SupplierDashbord.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Supplier Dashbord");
        window.setScene(scene);
        window.show();
    }
    void LoadData()
    {
        File f= new File("Supplierinfo.bin");
        Supplier s= null;
        
        try {        
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois= new ObjectInputStream(fis);
           s= (Supplier) ois.readObject();
              Notification.setText("Your Due Payment = "+s.getDuePayment());
            
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(DuePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DuePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DuePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
