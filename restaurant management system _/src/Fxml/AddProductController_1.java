/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import Fxml.AbdullahClass.Bulb;
import Fxml.AbdullahClass.Chair;
import Fxml.AbdullahClass.Equipment;
import Fxml.AbdullahClass.GlassSet;
import Fxml.AbdullahClass.Table;
import Fxml.AbdullahClass.PlateSet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AddProductController_1 implements Initializable {

    @FXML
    private CheckBox ChairCheckbox;
    @FXML
    private TextField ChairAmout;
    @FXML
    private CheckBox BulbCheckbox;
    @FXML
    private CheckBox TableCheckbox;
    @FXML
    private TextField TableAmout;
    @FXML
    private TextField BlubsetAmout;
    @FXML
    private CheckBox PlaterCheckbox;
    @FXML
    private CheckBox GlassCheckbox;
    @FXML
    private TextField PlateSetAmout;
    @FXML
    private TextField GlassAmout;
    ArrayList<Equipment> Equipmentlist=null;
    @FXML
    private TextField AmountSendMoney;
    @FXML
    private ComboBox<String> FileChoserTxt;
ObservableList<String> observableList = FXCollections.observableArrayList("availableEquipment.bin","ProductData.bin");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Equipmentlist = new ArrayList <Equipment>();
       
//        String[]a={"availableEquipment.bin","ProductData.bin"};
      
        FileChoserTxt.setItems(observableList);
        String fileName= FileChoserTxt.getValue();
        
    }    

    @FXML
    private void HandleAddProduct(ActionEvent event) {
        if(ChairCheckbox.isSelected())
        {
            Equipmentlist.add(new Chair( Integer.parseInt(ChairAmout.getText())));
        }
        if(TableCheckbox.isSelected())
        {
            Equipmentlist.add(new Table(Integer.parseInt(TableAmout.getText())));
        }
        if(BulbCheckbox.isSelected()){
             Equipmentlist.add(new Bulb(Integer.parseInt(BlubsetAmout.getText())));
        
        }
        if(GlassCheckbox.isSelected())
        {
            Equipmentlist.add(new GlassSet(Integer.parseInt(GlassAmout.getText())));
        }
        if(PlaterCheckbox.isSelected())
        {
            Equipmentlist.add(new PlateSet(Integer.parseInt(PlateSetAmout.getText())));
        }
        
    }

    @FXML
    private void HandleSaveOrder(ActionEvent event) {
        
        FileOutputStream fis=null;
        ObjectOutputStream ois= null;
        
        try {
            File f= new File(FileChoserTxt.getValue());
           {
                fis = new FileOutputStream(f);
               ois= new ObjectOutputStream(fis);
           
           }    
          
            for(Equipment e:Equipmentlist)
            {
                float a=  Float.parseFloat(AmountSendMoney.getText());
               e.setGetMoney((a));
                ois.writeObject(e);
            }
            ois.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddProductController_1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddProductController_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                
        
        
    }

    @FXML
    private void HandleAddProductToDashbord(ActionEvent event) throws IOException {
         
        String path = "CleaningSupervisor.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Cleaning Supervisor");
        window.setScene(scene);
        window.show();
    
        
    }
    
}
