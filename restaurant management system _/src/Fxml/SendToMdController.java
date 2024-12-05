/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import Fxml.AbdullahClass.DelivaryMan;
import Fxml.AbdullahClass.Equipment;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SendToMdController implements Initializable {

    @FXML
    private TextArea Sendtomdtxtarea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO

            Democlassses();
        } catch (IOException ex) {
            Logger.getLogger(SendToMdController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void HandleSendtomd(ActionEvent event) {
        
    }

    @FXML
    private void HandleBackbtn(ActionEvent event) throws IOException {
        String path = "SupplierDashbord.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Supplier Dashbord");
        window.setScene(scene);
        window.show();
        
    }
    
    void Democlassses() throws IOException
    {
        String str=" Order Data \n ";
        str+= LoadOrdersData();  
        str+= " Delivary Man data \n";
        str+= LoadDelivaryManData();
        Sendtomdtxtarea.setText(str);
        Writereport(str);
        
        
       
       
        
        
    }
    
    
    
  String LoadOrdersData()
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
                  str+=p.toString();
                  str+="\n";
                  
               }
               
//               System.out.print("done");
               
           } catch (FileNotFoundException ex) {
               
              
               
               
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           }
           finally{
               
                
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
             
        return str;
    }   
  
  
  
   String LoadDelivaryManData()
    {
        File f= new File("OrderdelivaryMan.bin");
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
                 // OrderList.add(p);
                  str+=p.toString();
                  str+="\n";
                  
               }
               
//               System.out.print("done");
               
           } catch (FileNotFoundException ex) {
               
           
               
               
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ShowOrderController.class.getName()).log(Level.SEVERE, null, ex);
           }
           finally{
                //OrderOutput.setText(str);
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
         return str;
    }
    
   
   
    void Writereport(String str)
    {
         File f= new File("reportData.txt");
        FileWriter fw= null;
        if(f.exists())
        {
             try {
                 fw = new FileWriter(f,true);
             } catch (IOException ex) {
                 Logger.getLogger(SendToMdController.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        else
        {
             try {
                 fw = new FileWriter(f);
             } catch (IOException ex) {
                 Logger.getLogger(SendToMdController.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
        try {
            fw.write(str);
            
        } catch (IOException ex) {
            System.out.print("This is from Md File Writer");
            
           // Logger.getLogger(SendToMdController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(SendToMdController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
      
    }
}
