/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import Fxml.AbdullahClass.CleaningSupervisor;
import java.io.DataInputStream;
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
import javafx.stage.Stage;
public class CleaningSupervisorController implements Initializable {

    @FXML
    private Label SupervisorName;
    @FXML
    private Label Supervisormonry;
    @FXML
    private Label NumberOfnotification;
    @FXML
    private Label SupervisorAg;
    private Label SupervisorBL;
    @FXML
    private Label SupervisorID;
    @FXML
    private Label NumberOfnotification1;

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LoadSupervisotData();
       if(LoadNotification())
       {
           NumberOfnotification1.setText("Check Notification....");
           NumberOfnotification.setText("");
       }
       else
       {
          NumberOfnotification1.setText("");
           NumberOfnotification.setText("No Notification "); 
       }
        
    }    

    @FXML
    private void Takeattendence(ActionEvent event) throws IOException {
        String path ="TakeAttendence.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("ADD Supervisor ");
        window.setScene(scene);
        window.show();  
        
    }

    @FXML
    private void addemploye(ActionEvent event) throws IOException {
        String path ="Supervisoradd.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("ADD Supervisor ");
        window.setScene(scene);
        window.show();        
        
    }
    



    @FXML
    private void WithdrowMoney(ActionEvent event) throws IOException { 
        String path = "CleaningSupervisorWithdrow.fxml";
        CleaningSupervisorWithdrowController p1 = new CleaningSupervisorWithdrowController();
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Withdrow Money");
        window.setScene(scene);
        window.show();
    }
    

    
    
    
CleaningSupervisor LoadSupervisotData()
{
    File f= new File ("Supervisorinfo.bin");
    CleaningSupervisor p=null;
    
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois= new ObjectInputStream(fis);
           p =(CleaningSupervisor) ois.readObject();
           System.out.print(p.toString());
           SupervisorAg.setText(String.valueOf(p.getEmployeeage()));
           SupervisorName.setText(p.getEmployeName());
           Supervisormonry.setText(String.valueOf(p.getSalary()));
           SupervisorID.setText(String.valueOf(p.getEmployeId()));
           
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CleaningSupervisorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CleaningSupervisorController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CleaningSupervisorController.class.getName()).log(Level.SEVERE, null, ex);
        }
     return p;

}

    @FXML
    private void LeaveApplications(ActionEvent event) throws IOException {
        
               String path = "LeaveApplications.fxml";
        CleaningSupervisorWithdrowController p1 = new CleaningSupervisorWithdrowController();    
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Withdrow Money");
        window.setScene(scene);
        window.show();
        
    }

    @FXML
    private void RemoveEmployee(ActionEvent event) throws IOException {
         String path ="RemovingEmployee.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Removing ...");
        window.setScene(scene);
        window.show();  
    }

    @FXML
    private void UploadSchedule(ActionEvent event) throws IOException {
         String path ="SchedulePosting.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("SchedulePosting ...");
        window.setScene(scene);
        window.show(); 
        
    }

    @FXML
    private void Handlecomplain(ActionEvent event) throws IOException {
        File f2= new File("EsupervisorNotification.bin");
        f2.delete();
        String path ="PostNotification.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("SchedulePosting ...");
        window.setScene(scene);
        window.show(); 
        
    }
 
boolean  LoadNotification()
{
       File f= new File("SupervisorNotification.txt");
        File f2= new File("EsupervisorNotification.bin");

        
    if(f2.exists())
    {
        System.out.println("Notification File is exist");
        try {
            FileInputStream fis= new FileInputStream(f2);
            DataInputStream dis = new DataInputStream(fis);
            boolean a= dis.readBoolean();
            dis.close();
            return a;
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(CleaningSupervisorController.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
               Logger.getLogger(CleaningSupervisorController.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }
    else{
         System.out.println("Notification File is not exist");
         
         return false;
    }
    return false;
}

    @FXML
    private void HandleSeecomplain(ActionEvent event) throws IOException {
        String path ="SeeComplain.fxml";
        
       
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("SeeComplain...");
        window.setScene(scene);
        window.show(); 
    }

    @FXML
    private void HandleAddproduct(ActionEvent event) throws IOException {
        String path ="NewAddOrder.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("SeeComplain...");
        window.setScene(scene);
        window.show(); 
    }

}


