/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import Fxml.AbdullahClass.DelivaryMan;
import Fxml.AbdullahClass.Equipment;
import Fxml.AbdullahClass.Supplier;
import Fxml.AbdullahClass.TableViewExtraClass;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
public class Dalivary2Controller implements Initializable {

    @FXML
    private TableView<DelivaryMan> Deliverymanviewtable;
    @FXML
    private TableColumn<DelivaryMan, String> Nameclm;
    @FXML
    private TableColumn<DelivaryMan, String> locationculm;
    @FXML
    private TableColumn<DelivaryMan, Integer> phnclm;
    @FXML
    private TableColumn<DelivaryMan,Integer> rateclm;
    ObservableList<DelivaryMan> DelivaryMans= FXCollections.observableArrayList();
    @FXML
    private Label notification;
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDatas();
        Nameclm.setCellValueFactory( new PropertyValueFactory<DelivaryMan,String>("DalivaryManName"));
        locationculm.setCellValueFactory( new PropertyValueFactory<DelivaryMan,String>("DelivaryManLoactoin"));
        phnclm.setCellValueFactory( new PropertyValueFactory<DelivaryMan,Integer>("DelivaryManPhn"));
        rateclm.setCellValueFactory( new PropertyValueFactory<DelivaryMan,Integer>("DelivaryManPrice"));
        Deliverymanviewtable.setItems(DelivaryMans);
        
    }    

    @FXML
    private void BacktotheDashbord(ActionEvent event) throws IOException {
                 String path = "SupplierDashbord.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Supplier Dashbord");
        window.setScene(scene);
        window.show();
    }
    
    void loadDatas()
    {
        File f= new File("DelivaryManList.bin");
        String str="";
         FileInputStream fis= null;
         ObjectInputStream ois= null;
         DelivaryMan p=null;
         Object obj;
         if(f.exists())
         {
           try {
               fis= new FileInputStream(f);
               ois= new ObjectInputStream(fis);
               while(true)
               {
                  p= (DelivaryMan)ois.readObject();
                  DelivaryMans.add(p); 
                }
               
           } catch (FileNotFoundException ex) {
               
              
               
               
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           }
           finally{
               
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
         else{System.out.print("else part");}
         
    }

    @FXML
    private void HandleTableview(MouseEvent event) throws FileNotFoundException {
        DelivaryMan d1= Deliverymanviewtable.getSelectionModel().getSelectedItem();
        notification.setText(d1.toString());
        Alert a= new Alert(AlertType.CONFIRMATION);
         a.setContentText("Do you want to booking this person");       
        if(a.showAndWait().get()==ButtonType.OK)
        {
            loadDataSuppler(d1.getDelivaryManPrice());
            WriteOrderdelivaryMan(d1);
            
              File f= new File("Delivaryinfo.txt");
              FileOutputStream fis = new FileOutputStream (f);
            try {
                ObjectOutputStream dis = new ObjectOutputStream (fis);
                dis.writeObject(d1);
                dis.close();
            } catch (IOException ex) {
                Logger.getLogger(Dalivary2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }   
                
    }
    
    
   void loadDataSuppler(int x) 
     {
         File f= new File("Supplierinfo.bin");    
         FileInputStream fis= null;
         ObjectInputStream ois= null;
         Supplier p=null;
         System.out.println();

           try {
               fis= new FileInputStream(f);
               ois= new ObjectInputStream(fis);
               p= (Supplier)ois.readObject(); 
               int temp=  p.getDuePayment()-x;
               int a= p.getDuePayment();
               System.out.println(temp+" "+x+" "+a);
           p.setDuePayment((int) temp);
           Newvalue( p);
           
           } catch (FileNotFoundException ex) {
               
               
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           }
           finally{
                
               // System.out.print("done");
                
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
    
    void Newvalue(Supplier p)
    {
          
        FileOutputStream fOs=null;
        ObjectOutputStream oOs= null;
        
        try {
            File fX= new File("Supplierinfo.bin");
           {
                fOs = new FileOutputStream(fX);
               oOs= new ObjectOutputStream(fOs);
               oOs.writeObject(p);
           
           }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
   void WriteOrderdelivaryMan(DelivaryMan d1)
           {
          
        FileOutputStream fOs=null;
        ObjectOutputStream oOs= null;
        
        try {
            File fX= new File("OrderdelivaryMan.bin");
           {
                fOs = new FileOutputStream(fX);
               oOs= new ObjectOutputStream(fOs);
               oOs.writeObject(d1);
           }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
     System.out.print("Delivary Man successfull write ... ");
    }  
}
