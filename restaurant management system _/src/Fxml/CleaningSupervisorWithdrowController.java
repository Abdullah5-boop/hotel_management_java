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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CleaningSupervisorWithdrowController implements Initializable {

    @FXML
    private Label Notifiaction1;
    @FXML
    private Label Notifiaction2;
    @FXML
    private TextField Amounttxt;
    @FXML
    private Label Oldbalancetxt;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        SetValueTxt();
        CleaningSupervisor p1= LoadSupervisotData();
        Oldbalancetxt.setText(String.valueOf(p1.getSalary()));
        
    }    
    void SetValueTxt()
    {
        CleaningSupervisor p1= LoadSupervisotData();
        Oldbalancetxt.setText(String.valueOf(p1.getSalary()));
    }

    @FXML
    private void HandleWithdrow(ActionEvent event) {
         int oldvalue= LoadSupervisotData().getSalary();
         int UserInput =Integer.parseInt(Amounttxt.getText());
         if((oldvalue ==0)|| (UserInput==0 ))
         {
           Notifiaction2.setText("Invalid Balance ......");
             Notifiaction1.setText("");  
         }
         else if(oldvalue<UserInput)
         {
             Notifiaction2.setText("Enter a valid input ...");
             Notifiaction1.setText("");
         }
         else
         {
             int a=  oldvalue-UserInput;
             CleaningSupervisor p1= LoadSupervisotData();
             p1.setSalary(a);
             UpdateNewData (p1);
             Notifiaction2.setText("");
             Notifiaction1.setText("Successfully withdrow money");           
         }
         
    }

    @FXML
    private void HandleBack(ActionEvent event) throws IOException {
           String path = "CleaningSupervisor.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Supplier Dashbord");
        window.setScene(scene);
        window.show();
    }
 
    
    CleaningSupervisor LoadSupervisotData(){
    File f= new File ("Supervisorinfo.bin");
    CleaningSupervisor p=null;
    
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois= new ObjectInputStream(fis);
           p =(CleaningSupervisor) ois.readObject();
          
           
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CleaningSupervisorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CleaningSupervisorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CleaningSupervisorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            
        }
     return p;

}
    
    void UpdateNewData (CleaningSupervisor p1)
    {
        File f= new File("Supervisorinfo.bin");
        try {
            FileOutputStream fis = new FileOutputStream(f);
            ObjectOutputStream ois = new ObjectOutputStream(fis);
            ois.writeObject(p1);
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CleaningSupervisorWithdrowController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CleaningSupervisorWithdrowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            SetValueTxt();
        }
        
    }
        
}

