/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import Fxml.AbdullahClass.CleaningSupervisor;
import Fxml.AbdullahClass.Equipment;
import java.io.File;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SupervisoraddController implements Initializable {

    @FXML
    private TextField SupervisorNametxt;
    @FXML
    private TextField SupervisorIdtxt;
    @FXML
    private TextField SupervisorAgetxt;
    @FXML
    private TextField Supervisorsalarytxt;
    @FXML
    private ComboBox<String> Filechoser;
    ArrayList <CleaningSupervisor> supervisorList;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        supervisorList= new ArrayList <CleaningSupervisor> ();

        String [] a= {"Supervisorinfo.bin","SupervisorEmployee.bin"};
        ObservableList<String> list = FXCollections.observableArrayList(a);
        Filechoser.setItems(list);
    }    

    @FXML
    private void HandleAddButton(ActionEvent event) {
        CleaningSupervisor c1= new CleaningSupervisor();
        c1.setEmployeName(SupervisorNametxt.getText());
        c1.setEmployeeage(Integer.parseInt(SupervisorAgetxt.getText()));
        c1.setSalary(Integer.parseInt(Supervisorsalarytxt.getText()));
        c1.setEmployeId(Integer.parseInt(SupervisorIdtxt.getText()));
        supervisorList.add(c1);
        SupervisorNametxt.clear();
        SupervisorAgetxt.clear();
        Supervisorsalarytxt.clear();
        SupervisorIdtxt.clear();
                
        
    }

    @FXML
    private void HandleSaveButton(ActionEvent event) {
        String path= Filechoser.getValue();
        System.out.print(path);
        {
            FileOutputStream fis=null;
            ObjectOutputStream ois= null;
        
        try {
            File f= new File(path);
           {
                fis = new FileOutputStream(f);
               ois= new ObjectOutputStream(fis);
           
           }    
          
            for( CleaningSupervisor e:supervisorList)
            {ois.writeObject(e);}
            ois.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                
        
        
    }
        
                
    }

    @FXML
    private void HabdleBack(ActionEvent event) throws IOException {
               String path = "CleaningSupervisor.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Cleaning Supervisor");
        window.setScene(scene);
        window.show();
    }
    
}
