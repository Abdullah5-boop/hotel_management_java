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

public class WithmoneyController implements Initializable {

    @FXML
    private TextField Amounttxt;
    @FXML
    private Label SalaryTxt;
    @FXML
    private Label Notificationtxt;
    @FXML
    private Label Notificationtxt2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        NotificationFunction();
        
        
        
    }    
    void  NotificationFunction()
    {
         int a= LoadData();
        SalaryTxt.setText(String.valueOf(a));
    }

    @FXML
    private void HandleBack(ActionEvent event) throws IOException {
        String path = "SupplierDashbord.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Supplier Dashbord");
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void HandleWithdrowMoney(ActionEvent event) {
        int amount = Integer.parseInt(Amounttxt.getText());
        int oldSalary=LoadData();
        if(amount>oldSalary)
        {
            Notificationtxt.setText("Give The corrent input ... ");
        }
        else
        {
            int newSalary= oldSalary-amount;
            updateData(newSalary);
            
        }     
      }
    int LoadData()
    {
        File f= new File("Supplierinfo.bin");
        Supplier s= null;
        int money=0;
        
        try {        
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois= new ObjectInputStream(fis);
           s= (Supplier) ois.readObject();
           //   Notification.setText("Your Due Payment = "+s.getDuePayment());
           money=s.getSalary();
                       
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(DuePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DuePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DuePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(" This is load data from withdrow "+money);
        return money;
    } 
    
    
    Supplier LoadDataprevious()
    {
        File f= new File("Supplierinfo.bin");
        Supplier s= null;
        int money=0;
        
        try {        
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois= new ObjectInputStream(fis);
           s= (Supplier) ois.readObject();
           //   Notification.setText("Your Due Payment = "+s.getDuePayment());
           money=s.getSalary();
           ois.close();
                       
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(DuePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DuePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DuePaymentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(" This is load data from withdrow "+money);
        return s;
    } 
    
    void updateData(int NewSalary)
    {
       Supplier s= LoadDataprevious();
       s.setSalary(NewSalary);
       File f= new File("Supplierinfo.bin");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(s);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WithmoneyController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WithmoneyController.class.getName()).log(Level.SEVERE, null, ex);
        }
       NotificationFunction();
       Notificationtxt.setText("");
       Notificationtxt2.setText("Successfully Done ");
       
    }
    
}
