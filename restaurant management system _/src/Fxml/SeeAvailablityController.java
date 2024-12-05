/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import Fxml.AbdullahClass.BookingDelivaryMan;
import Fxml.AbdullahClass.Bulb;
import Fxml.AbdullahClass.Chair;
import Fxml.AbdullahClass.Equipment;
import Fxml.AbdullahClass.GlassSet;
import Fxml.AbdullahClass.PlateSet;
import Fxml.AbdullahClass.Table;
import static com.sun.deploy.util.ReflectionUtil.instanceOf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SeeAvailablityController implements Initializable {

    @FXML
    private TextArea OrderOutput;
    @FXML
    private TextArea AvailableOutput;
    @FXML
    private Label SeeAvailablityOutput;
    @FXML
    private TextArea SeeAvailable;
    ArrayList <Equipment> OrderList;
    ArrayList<Equipment> AvailableList;
    ArrayList<Equipment> NewArrayList;
    Boolean a=false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OrderList = new ArrayList<Equipment>();
        AvailableList=new ArrayList<Equipment>();
        NewArrayList=new ArrayList<Equipment>();
        
        
      LoadOrderData();
      AvailableData();
      SeeAvailableLoader();
      
    }  
    void LoadOrderData()
    {
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
                  OrderList.add(p);
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
    
    void AvailableData(){
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
                  AvailableList.add(p);
                  str+=p.toString();
                  str+="\n";
                }
               
           } catch (FileNotFoundException ex) {
               
               AvailableOutput.setText(str);
               
               
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           }
           finally{
                AvailableOutput.setText(str);
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
             OrderOutput.setText("File is not here");
         }
         
    }
    
     void SeeAvailableLoader()
     
     {
         String str="";
         for(Equipment e1:AvailableList)
         {
             for(Equipment e2:OrderList)
             {
                 if(e1.getId()==e2.getId())
                 {
                    if(e1 instanceof Chair)
                    {
                        Equipment p1= new Chair();
                        int aa= e1.getAmount()-e2.getAmount();
                        p1.setAmount(aa);
                        p1.setTotalPrice(e1.getPrice()*aa);
                        NewArrayList.add(p1);
                    }
                    if(e1 instanceof Bulb)
                    {
                        Equipment p1= new Bulb();
                        int a= e1.getAmount()-e2.getAmount();
                        p1.setAmount(a);
                        p1.setTotalPrice(e1.getPrice()*a);
                        NewArrayList.add(p1);
                    }
                    if(e1 instanceof Table)
                    {
                        Equipment p1= new Table();
                        int a= e1.getAmount()-e2.getAmount();
                        p1.setAmount(a);
                        p1.setTotalPrice(e1.getPrice()*a);
                        NewArrayList.add(p1);
                    }
                    
                    
                    if(e1 instanceof GlassSet)
                    {
                        Equipment p1= new GlassSet();
                        int a= e1.getAmount()-e2.getAmount();
                        p1.setAmount(a);
                        p1.setTotalPrice(e1.getPrice()*a);
                        NewArrayList.add(p1);
                    }
                   
                    
                     if(e1 instanceof PlateSet)
                    {
                        Equipment p1= new PlateSet();
                        
                        int a= e1.getAmount()-e2.getAmount();
                        p1.setAmount(a);
                        p1.setTotalPrice(e1.getPrice()*a);
                        NewArrayList.add(p1);
                    }                   
                 }
             }            
         }
         
     for(Equipment eq:NewArrayList)
     {
         if(eq.getAmount()<0)
         {
             str+=" This product unavailble to supply ";
             str+="\n";
         }
         else{
         
         str+= eq.toString();
        str+="\n";
         }
        
     }
     SeeAvailable.setText(str);
     }
   


    
}
