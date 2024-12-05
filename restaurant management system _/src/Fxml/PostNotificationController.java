/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
public class PostNotificationController implements Initializable {

    private TextArea PostNotification;
    @FXML
    private TextArea InputTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backbtn(ActionEvent event) throws IOException {
        String path = "CleaningSupervisor.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Cleaning Supervisor");
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void confirm(ActionEvent event) {
        makeConfirm();
        UpdateStatus();
        
    
}
void makeConfirm()
{
    File f= new File("SupervisorNotification.txt");
    FileWriter fw=null;
    String a= InputTxt.getText();
    System.out.print(a);
    
     
        try {
             fw= new FileWriter(f);
            if(f.exists())
            {
                fw.write(a);
                
            }
            else
            {
               fw.write(a);
               
            }
            fw.close();
           
        } catch (IOException ex) {
            Logger.getLogger(PostNotificationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    
}

void UpdateStatus()
{
    {
    String str ="";
    
        File f= new File("SupervisorNotification.txt");
        File f2= new File("EsupervisorNotification.bin");
        try {
            FileOutputStream fos= new FileOutputStream(f2);
            DataOutputStream dos= new DataOutputStream(fos);
            
              if(f.exists()){dos.writeBoolean(true);
              dos.close();
              
              }
              else{dos.writeBoolean(false);
              
              dos.close();
              }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PostNotificationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PostNotificationController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
}

}

