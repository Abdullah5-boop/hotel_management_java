/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import Fxml.AbdullahClass.BookingDelivaryMan;
import Fxml.AbdullahClass.Equipment;
import Fxml.AbdullahClass.Supplier;
import Fxml.AbdullahClass.TableViewExtraClass;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CostOfProductController implements Initializable{
    @FXML
    private Label notification1;
    @FXML
    private Label Notification2;
     @FXML
    private TableView<TableViewExtraClass> CalculateCostTable;
    @FXML
    private TableColumn<TableViewExtraClass,String> ProductCulmnTxt;
    @FXML
    private TableColumn<TableViewExtraClass,Integer> Price;
    @FXML
    private TableColumn<TableViewExtraClass,Integer> TotalCostCulmntxt;
     @FXML
    private TableColumn<TableViewExtraClass, Integer> TotalCostCulmntxt1;
  
    ArrayList<Equipment> EquipmentOrderList;
    ArrayList<Equipment> AvailableList;
    ArrayList<Equipment> NewAvailableList;
    ObservableList<TableViewExtraClass> tableExtra= FXCollections.observableArrayList();
    @FXML
    private Button ConfirmBtn;
    @FXML
    private Label output;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EquipmentOrderList = new ArrayList <Equipment>();
        AvailableList =new ArrayList <Equipment>();
        NewAvailableList =new ArrayList <Equipment>();
        int TotalPrice = 0; 
        float UsergivenMoney=0;
        LoadOrderPoductData(TotalPrice,UsergivenMoney);
        
        ProductCulmnTxt.setCellValueFactory( new PropertyValueFactory<TableViewExtraClass,String>("productNames"));
        Price.setCellValueFactory( new PropertyValueFactory<TableViewExtraClass,Integer>("ProductPrice"));
        TotalCostCulmntxt.setCellValueFactory( new PropertyValueFactory<TableViewExtraClass,Integer>("TotalProductPrice"));
        TotalCostCulmntxt1.setCellValueFactory( new PropertyValueFactory<TableViewExtraClass,Integer>("amount"));
        CalculateCostTable.setItems( tableExtra);
    
    }    

    @FXML
    private void HandleConfirm(ActionEvent event) {
        LoadAvailableData();
        WriteAvailableData();
    
    }

    @FXML
    private void HandleBackToDashBord(ActionEvent event) throws IOException {
        String path = "SupplierDashbord.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Supplier Dashbord");
        window.setScene(scene);
        window.show();
    }
    
    void LoadOrderPoductData(int TotalPrice,float UsergivenMoney){
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
                   
                   int a,b,d;
                   float c;
                   String x;
                  p= (Equipment)ois.readObject();
                  TotalPrice+=p.getTotalPrice();
                  x= p.getProductName();
                  a= p.getPrice();
                  b= p.getTotalPrice();
                  c= p.getGetMoney();
                  UsergivenMoney = p.getGetMoney();
                  d=p.getAmount();
                  TableViewExtraClass t= new TableViewExtraClass(a,b,x,c,d);
                  tableExtra.add(t); 
                  EquipmentOrderList.add(p);
                  str+=p.toString();
                  str+="\n";
                  
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
         if(TotalPrice<UsergivenMoney)
         {
          notification1.setText("Your Total Cost = "+TotalPrice );
          Notification2.setText("Pay = "+UsergivenMoney );
          StoreMessageFortrue();
          float a = UsergivenMoney-TotalPrice;
          LoadAvailableData();
          loadDataSuppler(a) ;
         }
         else
         {
          notification1.setText("Your Total Cost = "+TotalPrice );
          Notification2.setText("Pay = "+UsergivenMoney+" Your Given money is less then your cost " );
         ConfirmBtn.setDisable(true);
         StoreMessageForFalse();
         
         
         }
    }
    
    void LoadAvailableData(){
    {
        File f= new File("availableEquipment.bin");
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
                  
                  for(Equipment ax : EquipmentOrderList)
                  {
                      if(ax.getId()== p.getId())
                      {
                          int NewAmount=p.getAmount()-ax.getAmount();
                          p.setAmount(NewAmount);
                      }
                  }
                  AvailableList.add(p);
                  
                  str+=p.toString();
                  str+="\n";
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
         else{
             
         }
         
    }
    }
    void WriteAvailableData() 
    {
        {
        
        FileOutputStream fis=null;
        ObjectOutputStream ois= null;
        
        try {
            File f= new File("availableEquipment.bin");
           {
                fis = new FileOutputStream(f);
               ois= new ObjectOutputStream(fis);
           
           }    
          
            for(Equipment e:AvailableList)
            {ois.writeObject(e);}
            ois.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConfirmBtn.setText("Done");
        ConfirmBtn.setDisable(true);
        }
    }            
 void StoreMessageFortrue()
 {
     File f= new File("Storenotification.bin");
        try {
            FileOutputStream fis= new FileOutputStream(f);
             DataOutputStream dos = new DataOutputStream(fis);
             dos.writeBoolean(true);
             dos.close();
             
    
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CostOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CostOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     
 }

void StoreMessageForFalse()
{
     File f= new File("Storenotification.bin");
        try {
            FileOutputStream fis= new FileOutputStream(f);
             DataOutputStream dos = new DataOutputStream(fis);
             dos.writeBoolean(false);
             dos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CostOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CostOfProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
     
 }

    @FXML
    private void HandleMousClickbtn(MouseEvent event) {
      // TableViewExtraClass p1=  CalculateCostTable.getSelectionModel().getSelectedItem();
       //output.setText(p1.toString());
       
    }

     
    
    
    
    
    void loadDataSuppler(float x) 
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
               float temp= x- p.getDuePayment();
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
     
     
     
     
     
     
     
     
     
     
     
     void SupplierUpdate(Supplier p,float x)
     {
         Supplier s= new Supplier();
         s.setDuePayment((int) (p.getDuePayment()-x));
         s.getBalance(p.getBalance());
         s.setSupplierName(p.getSupplierName());
        System.out.println(s.toString());
        
         
         
         
     }

}

