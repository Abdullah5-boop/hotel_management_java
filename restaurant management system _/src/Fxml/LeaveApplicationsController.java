/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import Fxml.AbdullahClass.CleaningSupervisor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class LeaveApplicationsController implements Initializable {

    @FXML
    private TextArea Inputtxt;
    @FXML
    private TextField Idtxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       
    }    

    @FXML
    private void HandleSendApplications(ActionEvent event) {
         LoadData();
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        String path = "CleaningSupervisor.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Cleaning Supervisor");
        window.setScene(scene);
        window.show();
    }
    
      void LoadData()
     {
    File f= new File ("Supervisorinfo.bin");
    CleaningSupervisor p=null;
    
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois= new ObjectInputStream(fis);
           p =(CleaningSupervisor) ois.readObject();
           p.setLeaveApplication(Inputtxt.getText());
           System.out.print(p.toString());
           applicationSend(p);
           Inputtxt.clear();
           Idtxt.clear();
           
           
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CleaningSupervisorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CleaningSupervisorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CleaningSupervisorController.class.getName()).log(Level.SEVERE, null, ex);
        }
     

}
      
      void applicationSend(CleaningSupervisor p)
      {
          File f= new File("Leavingapplication.txt");
        try {
            FileWriter fw= new FileWriter(f);
            fw.write(p.toString());
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(LeaveApplicationsController.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    
    
}
