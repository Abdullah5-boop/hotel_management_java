/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import Fxml.AbdullahClass.Equipment;
import Fxml.AbdullahClass.ProductClass;
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ShowOrderController implements Initializable {

    @FXML
    private TextArea OrderOutput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
//       File f= new File("ProductData.bin");
//       if(f.exists())
//       {
//           System.out.print(f.getPath());
//           
//       }else
//       {
//           OrderOutput.setText("none");
//       }
       
       
       
       
       File f= new File("ProductData.bin");
       
        String str="";
         FileInputStream fis= null;
         ObjectInputStream ois= null;
         Equipment p=null;
         Object obj;
         if(f.exists())
         {
           try {
               fis= new FileInputStream(f);
               ois= new ObjectInputStream(fis);
               while(true)
               {
                  p= (Equipment)ois.readObject();
                  str+=p.toString();
                  str+="\n";
                  
               }
               
//               System.out.print("done");
               
           } catch (FileNotFoundException ex) {
               
               OrderOutput.setText(str);
               
               
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           }
           finally{
                OrderOutput.setText(str);
                System.out.print("done");
                
               if(ois==null)
               {
                   try {
                       ois.close();
                   } catch (IOException ex) {
                       Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
           }
           
         }
             
        
    }    

    @FXML
    private void HandleShowOrderToDashbord(ActionEvent event) throws IOException {
        
        String path = "SupplierDashbord.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Supplier Dashbord");
        window.setScene(scene);
        window.show();

    }
    
}
