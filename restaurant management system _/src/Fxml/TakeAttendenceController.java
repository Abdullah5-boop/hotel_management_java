/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fxml;

import Fxml.AbdullahClass.CleaningSupervisor;
import Fxml.AbdullahClass.PerDayTakeAttendence;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TakeAttendenceController implements Initializable {

    @FXML
    private ComboBox<Integer> Employeelst;
    @FXML
    private TextArea Outputtxt;
    
    ObservableList <  Integer > supervisoremployeelist= FXCollections.observableArrayList();
//    ObservableList <Integer> Commobox = FXCollections.observableArrayList();
    ArrayList <CleaningSupervisor> Arraylists = null;
    ArrayList <PerDayTakeAttendence> Arraylists2 = null;
    @FXML
    private DatePicker DatePickerTxt;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Arraylists = new ArrayList<CleaningSupervisor>();
        Arraylists2 = new ArrayList<PerDayTakeAttendence>();
        LoadData();
        Employeelst.setItems(supervisoremployeelist);
  
        
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

    @FXML
    private void HandleTakeatttendece (ActionEvent event) {
        
       int x= Employeelst.getValue();
       String str;
        for(CleaningSupervisor a : Arraylists)
        {
            if(x==a.getEmployeId())
            {
                LocalDate l1= DatePickerTxt.getValue();
                PerDayTakeAttendence p1= new PerDayTakeAttendence();
                p1.setPresentdate(l1);
                p1.setPerson(a);
                Arraylists2.add(p1);
                OutputView();
               // WriteAttendence(p1);
                
            }
            
        }
        
        
    }


    
    
    void OutputView()
    {
        String str="";
        for(PerDayTakeAttendence a: Arraylists2)
        {
            str+=" Name = "+a.getPerson().getEmployeName()+" Id = "+a.getPerson().getEmployeId()+" Date = "+a.getPresentdate() ;
            str+="\n";
        }
        Outputtxt.setText(str);
        
    }
    
    
    
    
    
    
    
    
    @FXML
    private void HandleSave (ActionEvent event) 
    {
        WriteAttendence();
    }
    
    
    
    
    
    void LoadData()
    {
        File f= new File("SupervisorEmployee.bin");
          CleaningSupervisor p=null;
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois= new ObjectInputStream(fis);
            while(true)
            {
               p= (CleaningSupervisor) ois.readObject();
               supervisoremployeelist.add(p.getEmployeId());
               Arraylists.add(p);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TakeAttendenceController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TakeAttendenceController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TakeAttendenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    

    
    void WriteAttendence()
    {
        File f = new File("CleaningSupervisor.fxml");
        FileOutputStream fos=null;
         ObjectOutputStream oos= null;
        try {
            if(f.exists())
            {
            fos= new FileOutputStream(f,true);
            oos= new ObjectOutputStream(fos);
            }
            else{
            fos= new FileOutputStream(f);
           oos= new ObjectOutputStream(fos);
            }
            for(PerDayTakeAttendence p: Arraylists2)
            {
                oos.writeObject(p);
                
            }
            oos.close();
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TakeAttendenceController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TakeAttendenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
