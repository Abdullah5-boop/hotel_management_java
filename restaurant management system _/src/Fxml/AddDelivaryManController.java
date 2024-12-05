/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import Fxml.AbdullahClass.DelivaryMan;
import Fxml.AbdullahClass.Equipment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AddDelivaryManController implements Initializable {

    @FXML
    private TextField Nametxt;
    @FXML
    private TextField loactiontxt;
    @FXML
    private TextField phnnumbrtxt;
    @FXML
    private TextField Pricetxt;

   ArrayList<DelivaryMan> list = new ArrayList<DelivaryMan>();
    @FXML
    private Label Notification;
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void HandleAddDelivaryman(ActionEvent event) {
        String DalivaryManName= Nametxt.getText();
        String DelivaryManLoactoin= loactiontxt.getText();
        int DelivaryManPhn = Integer.parseInt(phnnumbrtxt.getText());
        int DelivaryManPrice= Integer.parseInt(Pricetxt.getText());
        DelivaryMan d1= new DelivaryMan (DalivaryManName,DelivaryManLoactoin,DelivaryManPhn ,DelivaryManPrice);
        list.add(d1);
        loactiontxt.clear();
        phnnumbrtxt.clear();
        Pricetxt.clear();
        Nametxt.clear();
    
    }

    @FXML
    private void HandleSaveDelivaryman(ActionEvent event){
        
        FileOutputStream fis=null;
        ObjectOutputStream ois= null;
        
        try {
            File f= new File("DelivaryManList.bin");
            if(f.exists())
            {
                fis = new FileOutputStream(f,true);
               ois= new AppendableObjectOutputStream(fis);
            }
            else
           {
                fis = new FileOutputStream(f);
               ois= new ObjectOutputStream(fis);
           
           }    
          
            for(DelivaryMan a: list)
            {
                ois.writeObject(a);
            }
            ois.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Notification.setText("value is save");
        
                
        
        
    }

    @FXML
    private void HandleBackBtn(ActionEvent event) throws IOException {
        String path = "SupplierDashbord.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Supplier Dashbord");
        window.setScene(scene);
        window.show();
    }
    
}
