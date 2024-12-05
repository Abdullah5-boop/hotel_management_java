/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import Fxml.AbdullahClass.Supplier;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AddsupplierController implements Initializable {

    @FXML
    private TextField SupplierName;
    @FXML
    private TextField SupplierSalary;
    @FXML
    private TextField SupplierDuepayment;
    @FXML
    private TextField SupplieBalace;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleaddSupplier(ActionEvent event) {
    writeSupplierinfo();
    }
 
    

    @FXML
    private void handleaddSuppliertoDashbord(ActionEvent event) throws IOException {
          String path = "SupplierDashbord.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Supplier Dashbord");
        window.setScene(scene);
        window.show();
    }
   
    
    
    void writeSupplierinfo(){
        {
        
        FileOutputStream fis=null;
        ObjectOutputStream ois= null;
        
        try {
            File f = new File("Supplierinfo.bin");
            
           {
                fis = new FileOutputStream(f);
               ois= new ObjectOutputStream(fis);

               Supplier s1= new Supplier(Integer.parseInt(SupplierDuepayment.getText()),SupplierName.getText(),Integer.parseInt(SupplierSalary.getText()),Integer.parseInt(SupplieBalace.getText())+3);
               ois.writeObject(s1);
           
           }
           
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }
    } 


}
